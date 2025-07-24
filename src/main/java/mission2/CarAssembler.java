package mission2;

import mission2.assemblestep.AssembleStep;

import static mission2.constant.AssembleStepConstant.CarType_Step;

public class CarAssembler {
    private int currentStep;
    private final AssembleStepFactory factory;

    public CarAssembler(AssembleStepFactory factory) {
        this.factory = factory;
        this.currentStep = CarType_Step;
    }

    public void showMenu() {
        String CLEAR_SCREEN = "\033[H\033[2J";
        System.out.print(CLEAR_SCREEN);
        System.out.flush();

        AssembleStep assembleStep = factory.getAssembleStep(currentStep);
        assembleStep.showMenu();
    }

    public boolean isValid(int answer) {
        AssembleStep assembleStep = factory.getAssembleStep(currentStep);
        return assembleStep.isValid(answer);
    }

    public void runAssembleSteps(int answer) {
        AssembleStep assembleStep = factory.getAssembleStep(currentStep);

        if (answer == 0) {
            currentStep = assembleStep.getBackStep(currentStep);
            return;
        }

        assembleStep.select(answer);
        currentStep = assembleStep.getNextStep(currentStep);
    }

}
