package mission2.assemblestep;

import mission2.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BrakeStepTest {

    @Test
    void showMenu() {
        AssembleStep step = new BrakeStep(Car.getInstance());
        step.showMenu();
    }

    @Test
    void isValid_true() {
        AssembleStep step = new BrakeStep(Car.getInstance());
        boolean result = step.isValid(1);
        assertThat(result).isTrue();
    }

    @Test
    void isValid_false() {
        AssembleStep step = new BrakeStep(Car.getInstance());
        boolean result = step.isValid(5);
        assertThat(result).isFalse();
    }

    @Test
    void select() {
    }

    @Test
    void getBackStep() {
        AssembleStep step = new BrakeStep(Car.getInstance());
        int result = step.getBackStep(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void getNextStep() {
        AssembleStep step = new BrakeStep(Car.getInstance());
        int result = step.getNextStep(1);
        assertThat(result).isEqualTo(2);
    }
}