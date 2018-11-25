package com.mabuonomo.springbootauthupdated;

import java.util.stream.Stream;

import com.mabuonomo.springbootauthupdated.bike.Bike;
import com.mabuonomo.springbootauthupdated.bike.BikeResolver;
import com.mabuonomo.springbootauthupdated.car.Car;
import com.mabuonomo.springbootauthupdated.car.CarResolver;
import com.mabuonomo.springbootauthupdated.person.Person;
import com.mabuonomo.springbootauthupdated.person.PersonResolver;

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
    ApplicationRunner init(CarResolver carResolver, BikeResolver bikeResolver, PersonResolver personResolver) {
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag",
                    "Ford Pinto", "Yugo GV").forEach(name -> {
                        Car car = new Car();
                        car.setName(name);
                        carResolver.saveCar(car);

                        Bike bike = new Bike();
                        bike.setName(name);
                        bikeResolver.saveBike(bike);

                        Person person = new Person();
                        person.setName(name);
                        personResolver.save(person);
                    });
        };
    }
}
