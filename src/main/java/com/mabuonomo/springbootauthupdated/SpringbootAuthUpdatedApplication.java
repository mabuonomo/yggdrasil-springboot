package com.mabuonomo.springbootauthupdated;

import java.util.stream.Stream;

import com.mabuonomo.springbootauthupdated.bike.Bike;
import com.mabuonomo.springbootauthupdated.bike.BikeService;
import com.mabuonomo.springbootauthupdated.car.Car;
import com.mabuonomo.springbootauthupdated.car.CarService;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringbootAuthUpdatedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAuthUpdatedApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    ApplicationRunner init(CarService carService, BikeService bikeService) {
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag",
                    "Ford Pinto", "Yugo GV").forEach(name -> {
                Car car = new Car();
                car.setName(name);
                carService.saveCar(car);

                Bike bike = new Bike();
                bike.setName(name);
                bikeService.saveBike(bike);
            });
        };
    }
}
