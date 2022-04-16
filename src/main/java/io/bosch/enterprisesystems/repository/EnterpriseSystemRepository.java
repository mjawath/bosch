package io.bosch.enterprisesystems.repository;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseSystemRepository extends JpaRepository<EnterpriseSystem, Long> {

//    SearchResult<EnterpriseSystem> search(SearchRequest request);
}
