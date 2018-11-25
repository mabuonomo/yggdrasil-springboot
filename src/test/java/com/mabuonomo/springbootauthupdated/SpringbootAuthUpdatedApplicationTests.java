/*package com.mabuonomo.springbootauthupdated;

import static org.junit.Assert.assertThat;

import com.mabuonomo.springbootauthupdated.car.Car;
import com.mabuonomo.springbootauthupdated.car.CarRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAuthUpdatedApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Car mario = new Car();
        mario.setName("Alex");

        entityManager.persist(mario);
        entityManager.flush();

        // when
        Car found = carRepository.findById(mario.getId());

        // then
        assertThat(found.getName()).isEqualTo(mario.getName());
    }

}
*/