package mission2;

import mission2.constant.BrakeConstant;
import mission2.constant.CarTypeConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getNewInstance() {
        Car instance = Car.getInstance();
        assertThat(instance).isInstanceOf(Car.class);
    }

    @Test
    void getSingletonInstance() {
        Car instance1 = Car.getInstance();
        Car instance2 = Car.getInstance();
        assertThat(instance1).isEqualTo(instance2);
    }

    @Test
    void selectCarType() {
        Car car = Car.getInstance();

        car.selectCarType(1);
        assertThat(car.getCarType()).isEqualTo(1);

        car.selectCarType(2);
        assertThat(car.getCarType()).isEqualTo(2);

        car.selectCarType(3);
        assertThat(car.getCarType()).isEqualTo(3);
    }

    @Test
    void selectEngine() {
        Car car = Car.getInstance();

        car.selectEngine(1);
        assertThat(car.getEngine()).isEqualTo(1);

        car.selectEngine(2);
        assertThat(car.getEngine()).isEqualTo(2);

        car.selectEngine(3);
        assertThat(car.getEngine()).isEqualTo(3);

        car.selectEngine(4);
        assertThat(car.getEngine()).isEqualTo(4);
    }

    @Test
    void selectBrake() {
        Car car = Car.getInstance();

        car.selectBrake(1);
        assertThat(car.getBrake()).isEqualTo(1);

        car.selectBrake(2);
        assertThat(car.getBrake()).isEqualTo(2);

        car.selectBrake(3);
        assertThat(car.getBrake()).isEqualTo(3);
    }

    @Test
    void selectSteering() {
        Car car = Car.getInstance();

        car.selectSteering(1);
        assertThat(car.getSteering()).isEqualTo(1);

        car.selectSteering(2);
        assertThat(car.getSteering()).isEqualTo(2);
    }

    @Test
    void run() {
        Car car = Car.getInstance();

        car.setCarType(CarTypeConstant.SEDAN);
        car.setBrake(BrakeConstant.CONTINENTAL);

        car.run();
    }

}