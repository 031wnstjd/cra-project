package mission2.assemblestep;

import mission2.Car;

import static mission2.utils.CommonUtil.delay;

public class BrakeStep implements AssembleStep {

    private Car car;

    public BrakeStep(Car car) {
        this.car = car;
    }

    @Override
    public void showMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }

    @Override
    public boolean isValid(int answer) {
        if (answer >= 0 && answer <= 3) {
            return true;
        }
        System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
        return false;
    }

    @Override
    public void select(int answer) {
        car.selectBrake(answer);
        delay(800);
    }

    @Override
    public int getBackStep(int step) {
        return step - 1;
    }

    @Override
    public int getNextStep(int step) {
        return step + 1;
    }
}
