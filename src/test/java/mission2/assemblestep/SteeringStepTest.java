package mission2.assemblestep;

import mission2.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SteeringStepTest {

    @Mock
    private Car carMock;

    @InjectMocks
    private SteeringStep steeringStepWithMock;

    @Test
    void showMenu() {
        AssembleStep steeringStep = new SteeringStep(Car.getInstance());
        steeringStep.showMenu();
    }

    @Test
    void isValid_true() {
        AssembleStep steeringStep = new SteeringStep(Car.getInstance());
        boolean result = steeringStep.isValid(0);
        assertThat(result).isTrue();
    }

    @Test
    void isValid_false() {
        AssembleStep steeringStep = new SteeringStep(Car.getInstance());
        boolean result = steeringStep.isValid(5);
        assertThat(result).isFalse();
    }

    @Test
    void select() {
        steeringStepWithMock.select(1);
        verify(carMock).selectSteering(1);
    }

    @Test
    void getBackStep() {
        AssembleStep step = new SteeringStep(Car.getInstance());
        int result = step.getBackStep(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void getNextStep() {
        AssembleStep step = new SteeringStep(Car.getInstance());
        int result = step.getNextStep(1);
        assertThat(result).isEqualTo(2);
    }
}