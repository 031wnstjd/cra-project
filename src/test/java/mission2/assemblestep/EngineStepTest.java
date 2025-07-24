package mission2.assemblestep;

import mission2.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EngineStepTest {

    @Mock
    private Car carMock;

    @InjectMocks
    private EngineStep engineStepWithMock;


    @Test
    void showMenu() {
        AssembleStep engineStep = new EngineStep(Car.getInstance());
        engineStep.showMenu();
    }

    @Test
    void isValid_true() {
        AssembleStep engineStep = new EngineStep(Car.getInstance());
        boolean result = engineStep.isValid(1);
        assertThat(result).isTrue();
    }

    @Test
    void isValid_false() {
        AssembleStep engineStep = new EngineStep(Car.getInstance());
        boolean result = engineStep.isValid(5);
        assertThat(result).isFalse();
    }

    @Test
    void select() {
        engineStepWithMock.select(0);
        verify(carMock).selectEngine(0);
    }

    @Test
    void getBackStep() {
        AssembleStep step = new EngineStep(Car.getInstance());
        int result = step.getBackStep(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void getNextStep() {
        AssembleStep step = new EngineStep(Car.getInstance());
        int result = step.getNextStep(1);
        assertThat(result).isEqualTo(2);
    }

}