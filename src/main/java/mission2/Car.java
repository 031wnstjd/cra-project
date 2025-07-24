package mission2;

import mission2.constant.BrakeConstant;
import mission2.constant.CarTypeConstant;
import mission2.constant.SteeringConstant;

import static mission2.constant.EngineConstant.*;

public class Car {
    private int carType;
    private int engine;
    private int brake;
    private int steering;

    private static Car instance;

    private Car() {}

    public static Car getInstance() {
        if (instance == null) {
            instance = new Car();
        }

        return instance;
    }

    public void selectCarType(int answer) {
        carType = answer;
        System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", answer == 1 ? "Sedan" : answer == 2 ? "SUV" : "Truck");
    }

    public void selectEngine(int answer) {
        engine = answer;
        String name = answer == 1 ? "GM" : answer == 2 ? "TOYOTA" : answer == 3 ? "WIA" : "고장난 엔진";
        System.out.printf("%s 엔진을 선택하셨습니다.\n", name);
    }

    public void selectBrake(int answer) {
        brake = answer;
        String name = answer == 1 ? "MANDO" : answer == 2 ? "CONTINENTAL" : "BOSCH";
        System.out.printf("%s 제동장치를 선택하셨습니다.\n", name);
    }

    public void selectSteering(int answer) {
        steering = answer;
        String name = answer == 1 ? "BOSCH" : "MOBIS";
        System.out.printf("%s 조향장치를 선택하셨습니다.\n", name);
    }

    public void run() {
        if (!isValidCombination()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (engine == BROKEN_ENGINE) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        printCarInfo();
    }

    public void test() {
        if (isSedanWithContinentalBrakeSystem()) fail("Sedan에는 Continental제동장치 사용 불가");
        else if (isSuvWithToyotaEngine()) fail("SUV에는 TOYOTA엔진 사용 불가");
        else if (isTruckWithWiaEngine()) fail("Truck에는 WIA엔진 사용 불가");
        else if (isTruckWithMandoBrakeSystem()) fail("Truck에는 Mando제동장치 사용 불가");
        else if (isBoschBrakeSystemWithNonBoschSteeringSystem()) fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
        else System.out.println("자동차 부품 조합 테스트 결과 : PASS");
    }

    private void fail(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }

    private boolean isValidCombination() {
        if (isSedanWithContinentalBrakeSystem())            return false;
        if (isSuvWithToyotaEngine())                        return false;
        if (isTruckWithWiaEngine())                         return false;
        if (isTruckWithMandoBrakeSystem())                  return false;
        if (isBoschBrakeSystemWithNonBoschSteeringSystem()) return false;
        return true;
    }

    private void printCarInfo() {
        String[] carTypeNames = {"", "Sedan", "SUV", "Truck"};
        String[] engineNames = {"", "GM", "TOYOTA", "WIA"};
        String[] brakeSystemNames = {"", "Mando", "Continental", "Bosch"};
        String[] steeringSystemNames = {"", "Bosch", "Mobis"};

        System.out.printf("Car Type : %s\n", carTypeNames[carType]);
        System.out.printf("Engine   : %s\n", engineNames[engine]);
        System.out.printf("Brake    : %s\n", brakeSystemNames[brake]);
        System.out.printf("Steering : %s\n", steeringSystemNames[steering]);
        System.out.println("자동차가 동작됩니다.");
    }

    private boolean isSedanWithContinentalBrakeSystem() {
        return carType == CarTypeConstant.SEDAN && brake == BrakeConstant.CONTINENTAL;
    }

    private boolean isSuvWithToyotaEngine() {
        return carType == CarTypeConstant.SUV && engine == TOYOTA;
    }

    private boolean isTruckWithWiaEngine() {
        return carType == CarTypeConstant.TRUCK && engine == WIA;
    }

    private boolean isTruckWithMandoBrakeSystem() {
        return carType == CarTypeConstant.TRUCK && brake == BrakeConstant.MANDO;
    }

    private boolean isBoschBrakeSystemWithNonBoschSteeringSystem() {
        return brake == BrakeConstant.BOSCH_B && steering != SteeringConstant.BOSCH_S;
    }

}
