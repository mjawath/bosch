package io.bosch.enterprisesystems.repository;

import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;

public interface EnterpriseSystemCustomRepository {
    SearchResult search(SearchRequest searchRequest);
}
