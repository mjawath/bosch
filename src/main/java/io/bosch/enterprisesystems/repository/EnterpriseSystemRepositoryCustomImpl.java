package io.bosch.enterprisesystems.repository;

import io.bosch.enterprisesystems.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class EnterpriseSystemRepositoryCustomImpl implements EnterpriseSystemRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    //    @Override
    public SearchResult<EnterpriseSystem> search(SearchRequest searchRequest) {

        if (searchRequest == null || searchRequest.getFilterBy() == null || searchRequest.getFilterBy().isEmpty()) {
            return searchWithoutFilter(searchRequest);
        }
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EnterpriseSystem> criteriaQuery = cb.createQuery(EnterpriseSystem.class);
        Root<EnterpriseSystem> root = criteriaQuery.from(EnterpriseSystem.class);
        List<FilterElement> filterBy = searchRequest.getFilterBy();
        CriteriaQuery<EnterpriseSystem> select = criteriaQuery.select(root);
        CriteriaQuery<EnterpriseSystem> fq = select.where(getPredicates(filterBy, cb, root));
        Long itemProjected = getCount(cb, searchRequest);
        return applyPaging(searchRequest, getQuery(searchRequest,cb,criteriaQuery,root,fq), itemProjected);
    }

    private SearchResult<EnterpriseSystem> searchWithoutFilter(SearchRequest searchRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EnterpriseSystem> criteriaQuery = cb.createQuery(EnterpriseSystem.class);
        Root<EnterpriseSystem> root = criteriaQuery.from(EnterpriseSystem.class);
        CriteriaQuery<EnterpriseSystem> select = criteriaQuery.select(root);
        Long count = getCount(cb, null);
        return applyPaging(searchRequest, getQuery(searchRequest,cb, criteriaQuery, root, select), count);
    }

    private TypedQuery<EnterpriseSystem> getQuery(SearchRequest searchRequest, CriteriaBuilder cb, CriteriaQuery<EnterpriseSystem> criteriaQuery, Root<EnterpriseSystem> root, CriteriaQuery<EnterpriseSystem> select) {
        List<SortElement> sortBy = searchRequest.getSortBy();
        return entityManager.createQuery(
                Optional.ofNullable(sortBy)
                        .map(it -> criteriaQuery
                                .orderBy(it
                                        .stream()
                                        .map(t -> t.isAsc() ?
                                                cb.asc(root.get(t.getAttribute())) :
                                                cb.desc(root.get(t.getAttribute())))
                                        .collect(Collectors.toList())))
                        .orElse(select));
    }

    private SearchResult<EnterpriseSystem> applyPaging(SearchRequest searchRequest, TypedQuery<EnterpriseSystem> query, long itemProjected) {
        int pageNumber = 0;
        int pageSize = 10;//Todo from default environmental variable
        if (searchRequest.getPageable() != null) {
            pageNumber = searchRequest.getPageable().getPageNumber();
            pageSize = searchRequest.getPageable().getPageSize();
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
        }
        List<EnterpriseSystem> resultList = query.getResultList();
        return new SearchResult<>(resultList, searchRequest.getPageable(), itemProjected);
    }

    private Long getCount(CriteriaBuilder cb, SearchRequest searchRequest) {
        CriteriaQuery<Long> cr = cb.createQuery(Long.class);
        Root<EnterpriseSystem> rootx = cr.from(EnterpriseSystem.class);
        if (searchRequest == null) {
            cr.select(cb.count(rootx));
        } else {
            List<FilterElement> filterBy = searchRequest.getFilterBy();
            cr.select(cb.count(rootx)).where(getPredicates(filterBy, cb, rootx));
        }
        Query query = entityManager.createQuery(cr);
        return (Long) query.getSingleResult();
    }

    private Predicate[] getPredicates(List<FilterElement> filters, CriteriaBuilder cb, Root<EnterpriseSystem> root) {
        return filters.stream().map((FilterElement filterElement) -> getPredicate(filterElement, cb, root)).toArray(Predicate[]::new);
    }

    private Predicate getPredicate(FilterElement filterElement, CriteriaBuilder cb, Root<EnterpriseSystem> root) {
        if (Objects.isNull(filterElement.getOps()) || "eq".equalsIgnoreCase(filterElement.getOps())) {
            return cb.equal(root.get(filterElement.getAttribute()), filterElement.getValue());
        }
        switch (filterElement.getOps().toLowerCase()) {
            case "grt":
                return cb.greaterThan(root.get(filterElement.getAttribute()), filterElement.getValue());
            case "grt=":
                return cb.greaterThanOrEqualTo(root.get(filterElement.getAttribute()), filterElement.getValue());
            case "less":
                return cb.lessThan(root.get(filterElement.getAttribute()), filterElement.getValue());
            case "less=":
                return cb.lessThanOrEqualTo(root.get(filterElement.getAttribute()), filterElement.getValue());
            case "between":
                return cb.between(root.get(filterElement.getAttribute()), filterElement.getValue(), filterElement.getValue2());
            default:
                return cb.equal(root.get(filterElement.getAttribute()), filterElement.getValue());
        }
    }
}
