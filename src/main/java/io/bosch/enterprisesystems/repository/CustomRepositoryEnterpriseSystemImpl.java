package io.bosch.enterprisesystems.repository;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CustomRepositoryEnterpriseSystemImpl {
    @Autowired
    private EntityManager entityManager;
//    @Override
    public SearchResult<EnterpriseSystem> search(SearchRequest searchRequest) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EnterpriseSystem> criteriaQuery = cb.createQuery(EnterpriseSystem.class);
        Root<EnterpriseSystem> incidentRoot = criteriaQuery.from(EnterpriseSystem.class);
        List<Predicate> collect = searchRequest.getFilterBy().stream()
                .map(filter -> cb.equal(incidentRoot.get(filter.getAttribute()), filter.getValue()))
                .collect(Collectors.toList());
          entityManager.createQuery(criteriaQuery
                .select(incidentRoot)
//                .where(collect)
//                .orderBy(cb.asc()))
         ).getResultList();
        return  null;
    }
}
