package io.bosch.enterprisesystems.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SearchRequest
 */
@Validated

public class SearchRequest {
    @JsonProperty("filterBy")
    @Valid
    private List<FilterElement> filterBy;

    @JsonProperty("sortBy")
    @Valid
    private List<SortElement> sortBy;

    public SearchRequest filterBy(List<FilterElement> filterBy) {
        this.filterBy = filterBy;
        return this;
    }

    public SearchRequest addFilterByItem(FilterElement filterByItem) {
        if (this.filterBy == null) {
            this.filterBy = new ArrayList<FilterElement>();
        }
        this.filterBy.add(filterByItem);
        return this;
    }



    @Valid

    public List<FilterElement> getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(List<FilterElement> filterBy) {
        this.filterBy = filterBy;
    }

    public SearchRequest sortBy(List<SortElement> sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public SearchRequest addSortByItem(SortElement sortByItem) {
        if (this.sortBy == null) {
            this.sortBy = new ArrayList<SortElement>();
        }
        this.sortBy.add(sortByItem);
        return this;
    }




    public List<SortElement> getSortBy() {
        return sortBy;
    }

    public void setSortBy(List<SortElement> sortBy) {
        this.sortBy = sortBy;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchRequest seachRequest = (SearchRequest) o;
        return Objects.equals(this.filterBy, seachRequest.filterBy) &&
                Objects.equals(this.sortBy, seachRequest.sortBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filterBy, sortBy);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SeachRequest {\n");

        sb.append("    filterBy: ").append(toIndentedString(filterBy)).append("\n");
        sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
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

