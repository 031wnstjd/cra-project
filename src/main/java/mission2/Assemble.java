package mission2;

import java.util.Scanner;

import static mission2.utils.CommonUtil.*;

public class Assemble {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarAssembler carAssembler = new CarAssembler(Car.getInstance());

        while (true) {
            carAssembler.showMenu();

            String input = getInput(sc);
            if (isExitCommand(input)) break;

            Integer answer = convertToAnswer(input);
            if (answer == null) continue;

            if (!carAssembler.isValid(answer)) {
                delay(800);
                continue;
            }

            carAssembler.runAssemble(answer);
        }

        sc.close();
    }


    private static String getInput(Scanner sc) {
        System.out.print("INPUT > ");
        return sc.nextLine().trim();
    }

    private static boolean isExitCommand(String input) {
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
}
