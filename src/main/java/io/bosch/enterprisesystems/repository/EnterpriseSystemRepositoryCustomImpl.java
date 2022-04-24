package io.bosch.enterprisesystems.repository;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.FilterElement;
import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnterpriseSystemRepositoryCustomImpl implements EnterpriseSystemRepositoryCustom {
    @Autowired
    private EntityManager entityManager;
//    @Override
    public SearchResult<EnterpriseSystem> search(SearchRequest searchRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EnterpriseSystem> criteriaQuery = cb.createQuery(EnterpriseSystem.class);
        Root<EnterpriseSystem> root = criteriaQuery.from(EnterpriseSystem.class);

        CriteriaQuery<EnterpriseSystem> select = criteriaQuery
                .select(root);
        if(searchRequest==null){
            CriteriaQuery<EnterpriseSystem> fq = select;

            List<EnterpriseSystem> resultList = entityManager
                    .createQuery(fq)
                    .getResultList();

            CriteriaQuery<Long> cr = cb.createQuery(Long.class);
            Root<EnterpriseSystem> rootx = cr.from(EnterpriseSystem.class);
            cr.select(cb.count(rootx));
            Query query = entityManager.createQuery(cr);
            Long itemProjected = (Long) query.getSingleResult();

            return SearchResult.<EnterpriseSystem>builder()
                    .list(resultList)
                    .numberOfRecords(itemProjected)
                    .build();
        }
        CriteriaQuery<EnterpriseSystem> fq = select
                .where(getPredicates(searchRequest.getFilterBy(),cb,root));
        List<EnterpriseSystem> resultList = entityManager.createQuery(fq).getResultList();

        CriteriaQuery<Long> cr = cb.createQuery(Long.class);
        Root<EnterpriseSystem> rootx = cr.from(EnterpriseSystem.class);
        cr.select(cb.count(rootx)).where(getPredicates(searchRequest.getFilterBy(),cb,root));
        Query query = entityManager.createQuery(cr);
        Long itemProjected = (Long) query.getSingleResult();

        return SearchResult.<EnterpriseSystem>builder()
                .list(resultList)
                .numberOfRecords(itemProjected)
//                .pageable( PageRequest.of())
                .build();
    }
    private Predicate[] getPredicates(List<FilterElement> filters,CriteriaBuilder cb,Root<EnterpriseSystem> root){
        return filters
                .stream()
                .map(pf -> cb.equal(root.get(pf.getAttribute()), pf.getValue()))
                .toArray(Predicate[]::new);
    }
}
