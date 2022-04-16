package io.bosch.enterprisesystems.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class SearchResult<T> {
    private List<T> list;
}
