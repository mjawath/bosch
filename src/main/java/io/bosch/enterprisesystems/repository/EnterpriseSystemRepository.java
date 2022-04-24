package io.bosch.enterprisesystems.repository;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EnterpriseSystemRepository extends JpaRepository<EnterpriseSystem, Long>, EnterpriseSystemRepositoryCustom, JpaSpecificationExecutor<EnterpriseSystem> {

//    static Specification<EnterpriseSystem> hasCriteria(SearchRequest searchRequest) {
//        return (root, cq, cb) -> cb.equal(root.get("author"), author);
//    }


}
