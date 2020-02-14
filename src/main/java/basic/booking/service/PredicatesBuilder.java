package basic.booking.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PredicatesBuilder {
    private List<SearchCriteria> params;

    public PredicatesBuilder() {
        params = new ArrayList<>();
    }

    public PredicatesBuilder with(
            String key, String operation, Object value) {

        params.add(new SearchCriteria(key, operation, value));
        return this;
    }


}

