package com.mabuonomo.springbootauthupdated.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import io.leangen.graphql.annotations.GraphQLQuery;

@Table
public class Person {

    @Id
    @GraphQLQuery(name = "id", description = "A car's id")
    private int id;

    @GraphQLQuery(name = "name", description = "A car's name")
    private String name;

    @GraphQLQuery(name = "firstname", description = "A car's name")
    private String firstname;

    @GraphQLQuery(name = "lastname", description = "A car's name")
    private String lastname;

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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getFirstName() {
        return this.firstname;
    }

}