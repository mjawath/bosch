package io.bosch.enterprisesystems.service;

import io.bosch.enterprisesystems.api.mapper.EnterpriseSystemMapper;
import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;
import io.bosch.enterprisesystems.repository.EnterpriseSystemRepository;
import io.bosch.enterprisesystems.repository.GenericCustomSearchDAO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EnterpriseSystemServiceImpl implements EnterpriseSystemService {

    private final EnterpriseSystemRepository enterpriseSystemRepository;
    private final EnterpriseSystemMapper mapper;
    private final GenericCustomSearchDAO customSearchDAO;

    public EnterpriseSystemServiceImpl(EnterpriseSystemRepository enterpriseSystemRepository, EnterpriseSystemMapper mapper, GenericCustomSearchDAO customSearchDAO) {
        this.enterpriseSystemRepository = enterpriseSystemRepository;
        this.mapper = mapper;
        this.customSearchDAO = customSearchDAO;
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
    public SearchResult<EnterpriseSystem> get() {
        return customSearchDAO.search(null);
    }

    @Override
    public SearchResult<EnterpriseSystem> search(SearchRequest request) {
        return customSearchDAO.search(request);
    }

    @Override
    public void delete(Long id) {
        enterpriseSystemRepository.deleteById(id);
    }
}
