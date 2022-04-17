package io.bosch.enterprisesystems.service;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;

import java.util.Optional;

public interface EnterpriseSystemService {

    Optional<EnterpriseSystem> getById(Long id);

    EnterpriseSystem create(EnterpriseSystem request);

    SearchResult<EnterpriseSystem> search(SearchRequest request);

    void delete(Long id);
}
