package mission2.assemblestep;

import mission2.Car;

import static mission2.constant.AssembleStepConstant.CarType_Step;
import static mission2.utils.CommonUtil.delay;

public class RunTestStep implements AssembleStep {

    private Car car;

    public RunTestStep(Car car) {
        this.car = car;
    }

    @Override
    public void showMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }

    @Override
    public boolean isValid(int answer) {
        if (answer >= 0 && answer <= 2) {
            return true;
        }
        System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
        return false;
    }

    @Override
    public void select(int answer) {
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
    }

    @Override
    public int getBackStep(int step) {
        return CarType_Step;
    }

    @Override
    public int getNextStep(int step) {
        return step;
    }
}
