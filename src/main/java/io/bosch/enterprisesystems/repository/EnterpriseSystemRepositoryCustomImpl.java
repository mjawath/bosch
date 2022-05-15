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
        Long itemProjected = getCount(searchRequest);
        return applyPaging(searchRequest, itemProjected);
    }

    private TypedQuery<EnterpriseSystem> getQuery(SearchRequest searchRequest) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EnterpriseSystem> criteriaQuery = criteriaBuilder.createQuery(EnterpriseSystem.class);
        Root<EnterpriseSystem> root = criteriaQuery.from(EnterpriseSystem.class);
        CriteriaQuery<EnterpriseSystem> select = criteriaQuery.select(root);
        CriteriaQuery<EnterpriseSystem> where = applyFilter(searchRequest, criteriaBuilder, root, select);
        return entityManager.createQuery(applySorts(searchRequest, criteriaBuilder, root, where));
    }

    private CriteriaQuery<EnterpriseSystem> applySorts(SearchRequest searchRequest, CriteriaBuilder criteriaBuilder, Root<EnterpriseSystem> root, CriteriaQuery<EnterpriseSystem> where) {
        return Optional.ofNullable(searchRequest).map(SearchRequest::getSortBy)
                .map(it -> where
                        .orderBy(it
                                .stream()
                                .map(t -> t.isAsc() ?
                                        criteriaBuilder.asc(root.get(t.getAttribute())) :
                                        criteriaBuilder.desc(root.get(t.getAttribute())))
                                .collect(Collectors.toList())))
                .orElse(where);
    }

    private CriteriaQuery applyFilter(SearchRequest searchRequest, CriteriaBuilder criteriaBuilder, Root root, CriteriaQuery select) {
        return Optional.ofNullable(searchRequest).map(SearchRequest::getFilterBy)
                .map(it -> select.where(getPredicates(it, criteriaBuilder, root)))
                .orElse(select);
    }

    private SearchResult<EnterpriseSystem> applyPaging(SearchRequest searchRequest, long itemProjected) {
        TypedQuery<EnterpriseSystem> query = getQuery(searchRequest);

        Optional.ofNullable(searchRequest).map(SearchRequest::getPageable).ifPresent(it->{
            int pageNumber = 0;
            int pageSize = 10;//Todo from default environmental variable
            pageNumber = searchRequest.getPageable().getPageNumber();
            pageSize = searchRequest.getPageable().getPageSize();
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
        });
        List<EnterpriseSystem> resultList = query.getResultList();
        return new SearchResult<>(resultList,   Optional.ofNullable(searchRequest)
                .map(SearchRequest::getPageable)
                .orElse(new PageRequest(1,resultList.size())), itemProjected);
    }

    private Long getCount(SearchRequest searchRequest) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<EnterpriseSystem> root = criteriaQuery.from(EnterpriseSystem.class);
        CriteriaQuery<Long> select = criteriaQuery.select(criteriaBuilder.count(root));
        CriteriaQuery<Long> where = applyFilter(searchRequest, criteriaBuilder, root, select);
        Query query = entityManager.createQuery(where);
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
