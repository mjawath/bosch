package io.bosch.enterprisesystems.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * FilterElement
 */
@Validated

@Getter
@Setter
public class FilterElement {
    @NotNull
    @JsonProperty("attribute")
    private String attribute;
    @NotNull
    @JsonProperty("value")
    private String value;

    @JsonProperty("value2")
    private String value2;

    @JsonProperty("ops")
    private String ops;

    @JsonProperty("orOrAnd")
    private String orOrAnd;

}

