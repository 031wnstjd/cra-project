package mission2.assemblestep;

import mission2.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RunTestStepTest {

    @Mock
    private Car carMock;

    @InjectMocks
    private RunTestStep runTestStepWithMock;

    @Test
    void showMenu() {
        AssembleStep runTestStep = new RunTestStep(Car.getInstance());
        runTestStep.showMenu();
    }

    @Test
    void isValid_true() {
        AssembleStep runTestStep = new RunTestStep(Car.getInstance());
        boolean result = runTestStep.isValid(0);
        assertThat(result).isTrue();
    }

    @Test
    void isValid_false() {
        AssembleStep runTestStep = new RunTestStep(Car.getInstance());
        boolean result = runTestStep.isValid(5);
        assertThat(result).isFalse();
    }
    @Test
    void select1() {
        runTestStepWithMock.select(1);
        verify(carMock).run();
    }

    @Test
    void select2() {
        runTestStepWithMock.select(2);
        verify(carMock).test();
    }

    @Test
    void getBackStep() {
        AssembleStep step = new RunTestStep(Car.getInstance());
        int result = step.getBackStep(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void getNextStep() {
        AssembleStep step = new RunTestStep(Car.getInstance());
        int result = step.getNextStep(1);
        assertThat(result).isEqualTo(1);
    }
}