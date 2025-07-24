package mission2;

import static mission2.AssembleStep.*;
import static mission2.utils.CommonUtil.*;

public class CarAssembler {
    private final Car car;
    private int currentStep;

    public CarAssembler(Car car) {
        this.car = car;
        this.currentStep = CarType_Step;
    }

    public void showMenu() {
        String CLEAR_SCREEN = "\033[H\033[2J";
        System.out.print(CLEAR_SCREEN);
        System.out.flush();

        if (currentStep == CarType_Step) showCarTypeMenu();
        if (currentStep == Engine_Step) showEngineMenu();
        if (currentStep == Brake_Step) showBrakeMenu();
        if (currentStep == Steering_Step) showSteeringMenu();
        if (currentStep == RunTest_Step) showRunTestMenu();
    }

    public boolean isValid(int answer) {
        if (isInvalidCarType(answer)) {
            System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
            return false;
        }
        if (isInvalidEngine(answer)) {
            System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
            return false;
        }
        if (isInvalidBrake(answer)) {
            System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
            return false;
        }
        if (isInvalidSteering(answer)) {
            System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
            return false;
        }
        if (isInvalidRunTest(answer)) {
            System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
            return false;
        }
        return true;
    }

    public void runAssemble(int answer) {
        if (answer == 0 && currentStep == RunTest_Step) {
            currentStep = CarType_Step;
            return;
        }

        if (answer == 0 && currentStep > CarType_Step) {
            currentStep--;
            return;
        }

        switch (currentStep) {
            case CarType_Step:
                car.selectCarType(answer);
                delay(800);
                currentStep = Engine_Step;
                break;
            case Engine_Step:
                car.selectEngine(answer);
                delay(800);
                currentStep = Brake_Step;
                break;
            case Brake_Step:
                car.selectBrake(answer);
                delay(800);
                currentStep = Steering_Step;
                break;
            case Steering_Step:
                car.selectSteering(answer);
                delay(800);
                currentStep = RunTest_Step;
                break;
            case RunTest_Step:
                if (answer == 1) {
                    car.run();
                    delay(2000);
                }
                if (answer == 2) {
                    System.out.println("Test...");
                    delay(1500);
                    car.test();
                    delay(2000);
                }
                break;
        }
    }

    private boolean isInvalidCarType(int answer) {
        return currentStep == CarType_Step && !(answer >= 1 && answer <= 3);
    }

    private boolean isInvalidEngine(int answer) {
        return currentStep == Engine_Step && !(answer >= 0 && answer <= 4);
    }

    private boolean isInvalidBrake(int answer) {
        return currentStep == Brake_Step && !(answer >= 0 && answer <= 3);
    }

    private boolean isInvalidSteering(int answer) {
        return currentStep == Steering_Step && !(answer >= 0 && answer <= 2);
    }

    private boolean isInvalidRunTest(int answer) {
        return currentStep == RunTest_Step && !(answer >= 0 && answer <= 2);
    }


    private void showCarTypeMenu() {
        System.out.println("        ______________");
        System.out.println("       /|            |");
        System.out.println("  ____/_|_____________|____");
        System.out.println(" |                      O  |");
        System.out.println(" '-(@)----------------(@)--'");
        System.out.println("===============================");
        System.out.println("어떤 차량 타입을 선택할까요?");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Truck");
        System.out.println("===============================");
    }

    private void showEngineMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }

    private void showBrakeMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }

    private void showSteeringMenu() {
        System.out.println("어떤 조향장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. BOSCH");
        System.out.println("2. MOBIS");
        System.out.println("===============================");
    }

    private void showRunTestMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }
}
