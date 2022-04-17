package io.bosch.enterprisesystems.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.bosch.enterprisesystems.api.dto.EnterpriseSystemCreateResponse;
import io.bosch.enterprisesystems.api.dto.EnterpriseSystemsCreateRequest;
import io.bosch.enterprisesystems.api.mapper.EnterpriseSystemMapper;
import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;
import io.bosch.enterprisesystems.service.EnterpriseSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Optional;

@Slf4j
@RestController
public class EnterpriseSystemsApiController implements EnterpriseSystemsApi {

    private final EnterpriseSystemService enterpriseSystemService;
    private final EnterpriseSystemMapper enterpriseSystemMapper;

    @Autowired
    public EnterpriseSystemsApiController(EnterpriseSystemService enterpriseSystemService, EnterpriseSystemMapper enterpriseSystemDto, EnterpriseSystemMapper enterpriseSystemMapper) {
        this.enterpriseSystemService = enterpriseSystemService;
        this.enterpriseSystemMapper = enterpriseSystemMapper;
    }

    public ResponseEntity<EnterpriseSystemCreateResponse> addNewEnterpriseSystem(EnterpriseSystemsCreateRequest enterpriseSystemsCreateRequest) {

        log.info("addNewEnterpriseSystem  " + enterpriseSystemsCreateRequest);
        EnterpriseSystem enterpriseSystem = enterpriseSystemService
                .create(enterpriseSystemMapper.mapCreateToEntity(enterpriseSystemsCreateRequest));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(enterpriseSystem.getId())
                .toUri();
        log.info("addNewEnterpriseSystem  completed {}" , enterpriseSystem.getId());

        return ResponseEntity.created(location)
                .body(EnterpriseSystemCreateResponse.builder()
                        .id(enterpriseSystem.getId()).build());
    }


    public ResponseEntity<SearchResult<EnterpriseSystem>> findEnterpriseSystems(SearchRequest filter) {
        SearchResult search = enterpriseSystemService.search(filter);
        ResponseEntity<SearchResult<EnterpriseSystem>> ok = ResponseEntity.ok(search);
        return ok;
    }


    public ResponseEntity<EnterpriseSystem> getEnterpriseSystem(Long id) {
        Optional<EnterpriseSystem> byId = enterpriseSystemService.getById(id);
        return byId.map(ResponseEntity::ok).orElseGet(() -> {
            log.info("item {} not found ", id);
            return ResponseEntity.notFound().build();
        });
    }

    public ResponseEntity<Void> updateEnterpriseSystems(@RequestBody EnterpriseSystem body) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
    public ResponseEntity<Void> deleteEnterpriseSystem(@PathVariable("id") Long id){
        enterpriseSystemService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}