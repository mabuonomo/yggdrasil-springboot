package com.mabuonomo.springbootauthupdated.bike;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    private final BikeRepository carRepository;

    public BikeService(BikeRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GraphQLQuery(name = "bikes")
    public Iterable<Bike> getBike() {
        return carRepository.findAll();
    }

    @GraphQLQuery(name = "bike")
    public Optional<Bike> getBikeById(@GraphQLArgument(name = "id") Long id) {
        return carRepository.findById(id);
    }

    @GraphQLMutation(name = "saveBike")
    public Bike saveBike(@GraphQLArgument(name = "bike") Bike bike) {
        return carRepository.save(bike);
    }

    @GraphQLMutation(name = "deleteBike")
    public void deleteBike(@GraphQLArgument(name = "id") Long id) {
        carRepository.deleteById(id);
    }
}