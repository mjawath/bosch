package io.bosch.enterprisesystems.repository;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.SearchRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EnterpriseSystemRepository extends JpaRepository<EnterpriseSystem, Long>,EnterpriseSystemCustomRepository, JpaSpecificationExecutor<EnterpriseSystem> {

//    static Specification<EnterpriseSystem> hasCriteria(SearchRequest searchRequest) {
//        return (root, cq, cb) -> cb.equal(root.get("author"), author);
//    }
}
