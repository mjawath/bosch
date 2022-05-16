package io.bosch.enterprisesystems.repository;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component// generic dao for search
public class GenericCustomSearchDAO {

    @Autowired
    private EntityManager entityManager;

    public SearchResult<EnterpriseSystem> search(SearchRequest searchRequest) {
        GenericSearchSpecification<EnterpriseSystem> genericSearchSpecification = new GenericSearchSpecification<>(EnterpriseSystem.class);
        Long itemProjected = genericSearchSpecification.getCount(entityManager, searchRequest);
        return genericSearchSpecification.applyPaging(entityManager, searchRequest, itemProjected);
    }
}
