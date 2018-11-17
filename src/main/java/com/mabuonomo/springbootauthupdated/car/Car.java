package com.mabuonomo.springbootauthupdated.car;

import org.springframework.data.annotation.Id;
import io.leangen.graphql.annotations.GraphQLQuery;

public class Car {

    @Id
    @GraphQLQuery(name = "id", description = "A car's id")
    private String id;

    @GraphQLQuery(name = "name", description = "A car's name")
    private String name;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}