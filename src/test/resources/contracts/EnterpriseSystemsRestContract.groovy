package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return enterprise system by id=1"

    request {
        url "/v1/enterprise-systems/1"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 1,
                name: "Test"
        )
    }
}