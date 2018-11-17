package com.mabuonomo.springbootauthupdated.bike;

import io.leangen.graphql.annotations.GraphQLQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @GraphQLQuery(name = "id", description = "A car's id")
    private int id;

    @GraphQLQuery(name = "name", description = "A car's name")
    private String name;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}