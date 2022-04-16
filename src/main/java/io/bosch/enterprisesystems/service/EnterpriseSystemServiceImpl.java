package io.bosch.enterprisesystems.service;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;
import io.bosch.enterprisesystems.repository.EnterpriseSystemRepository;
import io.bosch.enterprisesystems.api.mapper.EnterpriseSystemMapper;
import org.springframework.stereotype.Component;

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
    public SearchResult search(SearchRequest request) {
        return SearchResult.builder().build();
    }

    @Override
    public void delete(Long id) {

    }
}
