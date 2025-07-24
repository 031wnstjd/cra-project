package mission2.assemblestep;

import mission2.Car;

import static mission2.utils.CommonUtil.delay;

public class CarTypeStep implements AssembleStep {

    private Car car;

    public CarTypeStep(Car car) {
        this.car = car;
    }

    @Override
    public void showMenu() {
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

    @Override
    public boolean isValid(int answer) {
        if (answer >= 1 && answer <= 3) {
            return true;
        }
        System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
        return false;
    }

    @Override
    public void select(int answer) {
        car.selectCarType(answer);
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
