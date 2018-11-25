package com.mabuonomo.springbootauthupdated.person;

import org.springframework.data.annotation.Id;
import io.leangen.graphql.annotations.GraphQLQuery;

public class Person {

    @Id
    @GraphQLQuery(name = "id", description = "A car's id")
    private String id;

    @GraphQLQuery(name = "name", description = "A car's name")
    private String name;

    @GraphQLQuery(name = "firstname", description = "A car's name")
    private String firstname;

    @GraphQLQuery(name = "lastname", description = "A car's name")
    private String lastname;

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