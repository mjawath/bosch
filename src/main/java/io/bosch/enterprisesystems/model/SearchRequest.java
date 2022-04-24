package io.bosch.enterprisesystems.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * SearchRequest
 */
@Validated
@Builder
@Getter
@Setter
public class SearchRequest {
    @Valid
    private List<FilterElement> filterBy;
    @Valid
    private List<SortElement> sortBy;

    private PageRequest pageable;

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

