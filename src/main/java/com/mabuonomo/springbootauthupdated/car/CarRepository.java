package com.mabuonomo.springbootauthupdated.car;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, Long> {
}