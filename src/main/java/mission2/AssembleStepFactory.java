package mission2;

import mission2.assemblestep.*;

import static mission2.constant.AssembleStepConstant.*;

public class AssembleStepFactory {

    private Car car;

    public AssembleStepFactory(Car car) {
        this.car = car;
    }

    public AssembleStep getAssembleStep(int step) {
        if (step == CarType_Step) return new CarTypeStep(car);
        if (step == Engine_Step) return new EngineStep(car);
        if (step == Brake_Step) return new BrakeStep(car);
        if (step == Steering_Step) return new SteeringStep(car);
        if (step == RunTest_Step) return new RunTestStep(car);
        return null;
    }

}
