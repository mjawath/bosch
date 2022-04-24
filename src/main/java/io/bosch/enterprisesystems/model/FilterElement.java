package io.bosch.enterprisesystems.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * FilterElement
 */
@Validated

@Getter
@Setter
public class FilterElement {
    @JsonProperty("attribute")
    private String attribute;

    @JsonProperty("value")
    private String value;

}

