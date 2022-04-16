package io.bosch.enterprisesystems.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * FilterElement
 */
@Validated


public class FilterElement {
    @JsonProperty("attribute")
    private String attribute;

    @JsonProperty("value")
    private String value;

    public FilterElement attribute(String attribute) {
        this.attribute = attribute;
        return this;
    }
   public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public FilterElement value(String value) {
        this.value = value;
        return this;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilterElement filterElement = (FilterElement) o;
        return Objects.equals(this.attribute, filterElement.attribute) && Objects.equals(this.value, filterElement.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attribute, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FilterElement {\n");

        sb.append("    attribute: ").append(toIndentedString(attribute)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

