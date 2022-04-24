package io.bosch.enterprisesystems.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SearchRequest
 */
@Validated
@Builder
@Getter
@Setter
public class SearchRequest {
    @JsonProperty("filterBy")
    @Valid
    private List<FilterElement> filterBy;

    @JsonProperty("sortBy")
    @Valid
    private List<SortElement> sortBy;

    public SearchRequest addFilterByItem(FilterElement filterByItem) {
        if (this.filterBy == null) {
            this.filterBy = new ArrayList<FilterElement>();
        }
        this.filterBy.add(filterByItem);
        return this;
    }



    public SearchRequest addSortByItem(SortElement sortByItem) {
        if (this.sortBy == null) {
            this.sortBy = new ArrayList<SortElement>();
        }
        this.sortBy.add(sortByItem);
        return this;
    }

}

