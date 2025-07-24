package mission2.assemblestep;

import mission2.Car;

import static mission2.utils.CommonUtil.delay;

public class EngineStep implements AssembleStep {

    private Car car;

    public EngineStep(Car car) {
        this.car = car;
    }

    @Override
    public void showMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }

    @Override
    public boolean isValid(int answer) {
        if (answer >= 0 && answer <= 4) {
            return true;
        }
        System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
        return false;
    }

    @Override
    public void select(int answer) {
        car.selectEngine(answer);
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
