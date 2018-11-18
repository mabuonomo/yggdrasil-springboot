package com.mabuonomo.springbootauthupdated.bike;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BikeResolver {

    private final BikeRepository bikeRepository;

    public BikeResolver(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @GraphQLQuery(name = "bikes")
    public Iterable<Bike> getBike() {
        return bikeRepository.findAll();
    }

    @GraphQLQuery(name = "bike")
    public Optional<Bike> getBikeById(@GraphQLArgument(name = "id") Long id) {
        return bikeRepository.findById(id);
    }

    @GraphQLMutation(name = "saveBike")
    public Bike saveBike(@GraphQLArgument(name = "bike") Bike bike) {
        return bikeRepository.save(bike);
    }

    @GraphQLMutation(name = "deleteBike")
    public void deleteBike(@GraphQLArgument(name = "id") Long id) {
        bikeRepository.deleteById(id);
    }
}