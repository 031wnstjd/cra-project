package mission2.assemblestep;

import mission2.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarTypeStepTest {

    @Mock
    private Car carMock;

    @InjectMocks
    private CarTypeStep carTypeStepWithMock;

    @Test
    void showMenu() {
        AssembleStep step = new CarTypeStep(Car.getInstance());
        step.showMenu();
    }

    @Test
    void isValid_true() {
        AssembleStep step = new CarTypeStep(Car.getInstance());
        boolean result = step.isValid(1);
        assertThat(result).isTrue();
    }

    @Test
    void isValid_false() {
        AssembleStep step = new CarTypeStep(Car.getInstance());
        boolean result = step.isValid(5);
        assertThat(result).isFalse();
    }

    @Test
    void select() {
        carTypeStepWithMock.select(0);
        verify(carMock).selectCarType(0);
    }

    @Test
    void getBackStep() {
        AssembleStep step = new CarTypeStep(Car.getInstance());
        int result = step.getBackStep(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void getNextStep() {
        AssembleStep step = new CarTypeStep(Car.getInstance());
        int result = step.getNextStep(1);
        assertThat(result).isEqualTo(2);
    }
}