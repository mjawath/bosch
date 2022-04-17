/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.26).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.bosch.enterprisesystems.api;

import io.bosch.enterprisesystems.api.dto.EnterpriseSystemCreateResponse;
import io.bosch.enterprisesystems.api.dto.EnterpriseSystemResponse;
import io.bosch.enterprisesystems.api.dto.EnterpriseSystemsCreateRequest;
import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.model.SearchRequest;
import io.bosch.enterprisesystems.model.SearchResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1/enterprise-systems")
public interface EnterpriseSystemsApi {

    @Operation(summary = "create an enterprise system",description = " create an enterprise system", tags={ "enterprise systems" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return the newly created enterprise system"),
            @ApiResponse(responseCode = "400", description = "Invalid request provided",content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred", content = @Content) })
    @PostMapping(value = "/")
    ResponseEntity<EnterpriseSystemCreateResponse> addNewEnterpriseSystem(EnterpriseSystemsCreateRequest enterpriseSystemsCreateRequest);

    @Operation(summary = "returns an enterprise system with the provided id", tags={ "enterprise systems" })
    @GetMapping(value = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "api will return a list of enterprise systems"),
            @ApiResponse(responseCode = "400", description = "Invalid request provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred", content = @Content) })
    ResponseEntity<EnterpriseSystemResponse> getEnterpriseSystem(@PathVariable("id") Long id);

    @Operation(summary = "search an enterprise system, api will return a list of enterprise systems" ,description = " search an enterprise system, api will return a list of enterprise systems", tags={ "enterprise systems" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "api will return a list of enterprise systems"),
            @ApiResponse(responseCode = "400", description = "Invalid request provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred", content = @Content) })
    @PostMapping(value = "/search")
    ResponseEntity<SearchResult<EnterpriseSystem>> findEnterpriseSystems(SearchRequest filter);


    @Operation(summary = "deletes an enterprise system with the provided id", tags={ "enterprise systems" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "api will delete the provided enterprise system"),
            @ApiResponse(responseCode = "400", description = "Invalid request provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred", content = @Content) })
    @DeleteMapping(value = "/")
    ResponseEntity<Void> deleteEnterpriseSystem(@PathVariable("id") Long id);

    @Operation(summary = "for an provided enterprise system with the provided id, update the information", tags={ "enterprise systems" })
    @PutMapping(value = "/")
    ResponseEntity<Void> updateEnterpriseSystems(@RequestBody EnterpriseSystem body);
}
