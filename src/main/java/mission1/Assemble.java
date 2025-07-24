package mission1;

import java.util.Scanner;

public class Assemble {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    private static final int CarType_Step = 0;
    private static final int Engine_Step = 1;
    private static final int BrakeSystem_Step = 2;
    private static final int SteeringSystem_Step = 3;
    private static final int RunTest_Step = 4;

    private static final int SEDAN = 1, SUV = 2, TRUCK = 3;
    private static final int GM = 1, TOYOTA = 2, WIA = 3;
    private static final int MANDO = 1, CONTINENTAL = 2, BOSCH_B = 3;
    private static final int BOSCH_S = 1, MOBIS = 2;

    private static int currentStep;

    private static int[] selectedTypes = new int[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        currentStep = CarType_Step;

        while (true) {
            System.out.print(CLEAR_SCREEN);
            System.out.flush();

            showMenu();

            String input = getInput(sc);
            if (isExit(input)) break;

            Integer answer = convertToAnswer(input);
            if (answer == null) continue;

            if (currentStep == CarType_Step) executeCarTypeSelection(answer);
            else if (currentStep == Engine_Step) executeEngineSelection(answer);
            else if (currentStep == BrakeSystem_Step) executeBrakeSystemSelection(answer);
            else if (currentStep == SteeringSystem_Step) executeSteeringSystemSelection(answer);
            else if (currentStep == RunTest_Step) executeRunTestSelection(answer);
        }

        sc.close();
    }

    private static void showMenu() {
        if (currentStep == CarType_Step) {
            showCarTypeMenu();
        }
        if (currentStep == Engine_Step) {
            showEngineMenu();
        }
        if (currentStep == BrakeSystem_Step) {
            showBrakeMenu();
        }
        if (currentStep == SteeringSystem_Step) {
            showSteeringMenu();
        }
        if (currentStep == RunTest_Step) {
            showRunTestMenu();
        }
    }

    private static void showCarTypeMenu() {
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

    private static void showEngineMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }

    private static void showBrakeMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }

    private static void showSteeringMenu() {
        System.out.println("어떤 조향장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. BOSCH");
        System.out.println("2. MOBIS");
        System.out.println("===============================");
    }

    private static void showRunTestMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }


    private static String getInput(Scanner sc) {
        System.out.print("INPUT > ");
        String input = sc.nextLine().trim();
        return input;
    }

    private static boolean isExit(String input) {
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("바이바이");
            return true;
        }
        return false;
    }

    private static Integer convertToAnswer(String input) {
        int answer;
        try {
            answer = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("ERROR :: 숫자만 입력 가능");
            delay(800);
            return null;
        }
        return answer;
    }

    private static void executeCarTypeSelection(Integer answer) {
        if (!isValidCarType(answer)) return;

        if (answer == 0) {
            currentStep--;
            return;
        }

        selectCarType(answer);
        delay(800);
        currentStep++;
    }

    private static boolean isValidCarType(Integer answer) {
        if (answer < 1 || answer > 3) {
            System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
            delay(800);
            return false;
        }
        return true;
    }

    private static void selectCarType(int answer) {
        selectedTypes[CarType_Step] = answer;
        System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", answer == 1 ? "Sedan" : answer == 2 ? "SUV" : "Truck");
    }

    private static void executeEngineSelection(Integer answer) {
        if (!isValidEngine(answer)) return;

        if (answer == 0) {
            currentStep--;
            return;
        }

        selectEngine(answer);
        delay(800);
        currentStep++;
    }

    private static boolean isValidEngine(Integer answer) {
        if (answer < 0 || answer > 4) {
            System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
            delay(800);
            return false;
        }
        return true;
    }

    private static void selectEngine(int answer) {
        selectedTypes[Engine_Step] = answer;
        String name = answer == 1 ? "GM" : answer == 2 ? "TOYOTA" : answer == 3 ? "WIA" : "고장난 엔진";
        System.out.printf("%s 엔진을 선택하셨습니다.\n", name);
    }

    private static void executeBrakeSystemSelection(Integer answer) {
        if (!isValidBrakeSystem(answer)) return;

        if (answer == 0) {
            currentStep--;
            return;
        }

        selectBrakeSystem(answer);
        delay(800);
        currentStep++;
    }

    private static boolean isValidBrakeSystem(Integer answer) {
        if (answer < 0 || answer > 3) {
            System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
            delay(800);
            return false;
        }
        return true;
    }

    private static void selectBrakeSystem(int answer) {
        selectedTypes[BrakeSystem_Step] = answer;
        String name = answer == 1 ? "MANDO" : answer == 2 ? "CONTINENTAL" : "BOSCH";
        System.out.printf("%s 제동장치를 선택하셨습니다.\n", name);
    }

    private static void executeSteeringSystemSelection(Integer answer) {
        if (!isValidSteeringSystem(answer)) return;

        if (answer == 0) {
            currentStep--;
            return;
        }

        selectSteeringSystem(answer);
        delay(800);
        currentStep++;
    }

    private static boolean isValidSteeringSystem(Integer answer) {
        if (answer < 0 || answer > 2) {
            System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
            delay(800);
            return false;
        }
        return true;
    }

    private static void selectSteeringSystem(int answer) {
        selectedTypes[SteeringSystem_Step] = answer;
        String name = answer == 1 ? "BOSCH" : "MOBIS";
        System.out.printf("%s 조향장치를 선택하셨습니다.\n", name);
    }
    private static void executeRunTestSelection(Integer answer) {
        if (!isValidRunTest(answer)) return;

        if (answer == 0) {
            currentStep = CarType_Step;
            return;
        }

        if (answer == 1) {
            runProducedCar();
        }

        if (answer == 2) {
            System.out.println("Test...");
            delay(1500);
            testProducedCar();
        }

        delay(2000);
    }
    private static boolean isValidRunTest(Integer answer) {
        if (answer < 0 || answer > 2) {
            System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
            delay(800);
            return false;
        }
        return true;
    }

    private static void runProducedCar() {
        if (!isValidCombination()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (isWrongEngine()) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        printCarInfo();
    }

    private static boolean isValidCombination() {
        if (isSedanWithContinentalBrakeSystem())            return false;
        if (isSuvWithToyotaEngine())                        return false;
        if (isTruckWithWiaEngine())                         return false;
        if (isTruckWithMandoBrakeSystem())                  return false;
        if (isBoschBrakeSystemWithNonBoschSteeringSystem()) return false;
        return true;
    }

    private static boolean isWrongEngine() {
        return selectedTypes[Engine_Step] == 4;
    }

    private static void printCarInfo() {
        String[] carTypeNames = {"", "Sedan", "SUV", "Truck"};
        String[] engineNames = {"", "GM", "TOYOTA", "WIA"};
        String[] brakeSystemNames = {"", "Mando", "Continental", "Bosch"};
        String[] steeringSystemNames = {"", "Bosch", "Mobis"};

        System.out.printf("Car Type : %s\n", carTypeNames[selectedTypes[CarType_Step]]);
        System.out.printf("Engine   : %s\n", engineNames[selectedTypes[Engine_Step]]);
        System.out.printf("Brake    : %s\n", brakeSystemNames[selectedTypes[BrakeSystem_Step]]);
        System.out.printf("Steering : %s\n", steeringSystemNames[selectedTypes[SteeringSystem_Step]]);
        System.out.println("자동차가 동작됩니다.");
    }

    private static void testProducedCar() {
        if (isSedanWithContinentalBrakeSystem()) fail("Sedan에는 Continental제동장치 사용 불가");
        else if (isSuvWithToyotaEngine()) fail("SUV에는 TOYOTA엔진 사용 불가");
        else if (isTruckWithWiaEngine()) fail("Truck에는 WIA엔진 사용 불가");
        else if (isTruckWithMandoBrakeSystem()) fail("Truck에는 Mando제동장치 사용 불가");
        else if (isBoschBrakeSystemWithNonBoschSteeringSystem()) fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
        else System.out.println("자동차 부품 조합 테스트 결과 : PASS");
    }

    private static void fail(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }

    private static boolean isSedanWithContinentalBrakeSystem() {
        return selectedTypes[CarType_Step] == SEDAN && selectedTypes[BrakeSystem_Step] == CONTINENTAL;
    }

    private static boolean isSuvWithToyotaEngine() {
        return selectedTypes[CarType_Step] == SUV && selectedTypes[Engine_Step] == TOYOTA;
    }

    private static boolean isTruckWithWiaEngine() {
        return selectedTypes[CarType_Step] == TRUCK && selectedTypes[Engine_Step] == WIA;
    }

    private static boolean isTruckWithMandoBrakeSystem() {
        return selectedTypes[CarType_Step] == TRUCK && selectedTypes[BrakeSystem_Step] == MANDO;
    }

    private static boolean isBoschBrakeSystemWithNonBoschSteeringSystem() {
        return selectedTypes[BrakeSystem_Step] == BOSCH_B && selectedTypes[SteeringSystem_Step] != BOSCH_S;
    }

    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
