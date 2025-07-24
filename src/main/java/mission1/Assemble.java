package mission1;

import java.util.Scanner;

public class Assemble {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    private static final int CarType_Step = 0;
    private static final int Engine_Step = 1;
    private static final int Brake_Step = 2;
    private static final int Steering_Step = 3;
    private static final int RunTest_Step = 4;

    private static final int SEDAN = 1, SUV = 2, TRUCK = 3;
    private static final int GM = 1, TOYOTA = 2, WIA = 3, BROKEN_ENGINE = 4;
    private static final int MANDO = 1, CONTINENTAL = 2, BOSCH_B = 3;
    private static final int BOSCH_S = 1, MOBIS = 2;

    private static int currentStep;

    private static int[] selected = new int[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        currentStep = CarType_Step;

        while (true) {
            System.out.print(CLEAR_SCREEN);
            System.out.flush();

            showMenu();

            String input = getInput(sc);
            if (isExitCommand(input)) break;

            Integer answer = convertToAnswer(input);
            if (answer == null) continue;

            if (!isValid(answer)) {
                delay(800);
                continue;
            }

            runAssemble(answer);
        }

        sc.close();
    }

    public static void showMenu() {
        if (currentStep == CarType_Step) showCarTypeMenu();
        if (currentStep == Engine_Step) showEngineMenu();
        if (currentStep == Brake_Step) showBrakeMenu();
        if (currentStep == Steering_Step) showSteeringMenu();
        if (currentStep == RunTest_Step) showRunTestMenu();
    }

    public static String getInput(Scanner sc) {
        System.out.print("INPUT > ");
        return sc.nextLine().trim();
    }

    public static boolean isExitCommand(String input) {
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("바이바이");
            return true;
        }
        return false;
    }

    public static Integer convertToAnswer(String input) {
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

    public static boolean isValid(int answer) {
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

    public static void runAssemble(int answer) {
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
                selected[CarType_Step] = answer;
                delay(800);
                currentStep = Engine_Step;
                break;
            case Engine_Step:
                selected[Engine_Step] = answer;
                delay(800);
                currentStep = Brake_Step;
                break;
            case Brake_Step:
                selected[Brake_Step] = answer;
                delay(800);
                currentStep = Steering_Step;
                break;
            case Steering_Step:
                selected[Steering_Step] = answer;
                delay(800);
                currentStep = RunTest_Step;
                break;
            case RunTest_Step:
                if (answer == 1) {
                    runCar();
                    delay(2000);
                }
                if (answer == 2) {
                    System.out.println("Test...");
                    delay(1500);
                    testCar();
                    delay(2000);
                }
                break;
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


    private static boolean isInvalidCarType(int answer) {
        return currentStep == CarType_Step && !(answer >= 1 && answer <= 3);
    }

    private static boolean isInvalidEngine(int answer) {
        return currentStep == Engine_Step && !(answer >= 0 && answer <= 4);
    }

    private static boolean isInvalidBrake(int answer) {
        return currentStep == Brake_Step && !(answer >= 0 && answer <= 3);
    }

    private static boolean isInvalidSteering(int answer) {
        return currentStep == Steering_Step && !(answer >= 0 && answer <= 2);
    }

    private static boolean isInvalidRunTest(int answer) {
        return currentStep == RunTest_Step && !(answer >= 0 && answer <= 2);
    }

    private static void runCar() {
        if (!isValidCombination()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (isBrokenEngine()) {
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

    private static boolean isBrokenEngine() {
        return selected[Engine_Step] == BROKEN_ENGINE;
    }

    private static void printCarInfo() {
        String[] carTypeNames = {"", "Sedan", "SUV", "Truck"};
        String[] engineNames = {"", "GM", "TOYOTA", "WIA"};
        String[] brakeSystemNames = {"", "Mando", "Continental", "Bosch"};
        String[] steeringSystemNames = {"", "Bosch", "Mobis"};

        System.out.printf("Car Type : %s\n", carTypeNames[selected[CarType_Step]]);
        System.out.printf("Engine   : %s\n", engineNames[selected[Engine_Step]]);
        System.out.printf("Brake    : %s\n", brakeSystemNames[selected[Brake_Step]]);
        System.out.printf("Steering : %s\n", steeringSystemNames[selected[Steering_Step]]);
        System.out.println("자동차가 동작됩니다.");
    }

    private static void testCar() {
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
        return selected[CarType_Step] == SEDAN && selected[Brake_Step] == CONTINENTAL;
    }

    private static boolean isSuvWithToyotaEngine() {
        return selected[CarType_Step] == SUV && selected[Engine_Step] == TOYOTA;
    }

    private static boolean isTruckWithWiaEngine() {
        return selected[CarType_Step] == TRUCK && selected[Engine_Step] == WIA;
    }

    private static boolean isTruckWithMandoBrakeSystem() {
        return selected[CarType_Step] == TRUCK && selected[Brake_Step] == MANDO;
    }

    private static boolean isBoschBrakeSystemWithNonBoschSteeringSystem() {
        return selected[Brake_Step] == BOSCH_B && selected[Steering_Step] != BOSCH_S;
    }

    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
