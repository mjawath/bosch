package io.bosch.enterprisesystems.service;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;
import io.bosch.enterprisesystems.repository.EnterpriseSystemRepository;
import io.bosch.enterprisesystems.api.mapper.EnterpriseSystemMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Component
public class EnterpriseSystemServiceImpl implements EnterpriseSystemService {

    private final EnterpriseSystemRepository enterpriseSystemRepository;
    private final EnterpriseSystemMapper mapper;

    public EnterpriseSystemServiceImpl(EnterpriseSystemRepository enterpriseSystemRepository, EnterpriseSystemMapper mapper) {
        this.enterpriseSystemRepository = enterpriseSystemRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<EnterpriseSystem> getById(Long id) {
        return enterpriseSystemRepository.findById(id);
    }

    @Override
    public EnterpriseSystem create(EnterpriseSystem enterpriseSystems) {
        return enterpriseSystemRepository.save(enterpriseSystems);
    }

    @Override
    public SearchResult<EnterpriseSystem> search(SearchRequest request) {
//        return enterpriseSystemRepository.search(request);
        return null;//todo search query
    }

    @Override
    public void delete(Long id) {
        enterpriseSystemRepository.deleteById(id);
    }
}
