package calculatingstep3;

import java.util.Scanner;

public class CalculatorStep03 {
    // 숫자 입력 시 문자 넣으면 에러남 : 검사
    public static int safeNextInt(Scanner scanner, int number) {
        while (true) {
            String input = scanner.next(); // 문자열로 먼저 받기

            // 숫자인지 직접 검사
            if (input.matches("-?\\d+")) { // 정수인지 체크 (음수도 가능)
                return Integer.parseInt(input);
            } else {
                System.out.print(number + "번째 숫자를 다시 입력하세요 : ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 제네릭 타입을 Integer로 사용 : 정수만 쓸꺼야
        ArithmeticCalculator<Integer> calcul = new ArithmeticCalculator<>();

        // 숫자 자리에 문자 들어가면 에러남 -> 검증 코드 추가
        while (true) {
            System.out.print("첫 번째 숫자 입력: ");
            // int number1 = scanner.nextInt();
            int number1 = safeNextInt(scanner, 1);

            System.out.print("연산자 입력 (+, -, *, /): ");
            char operationChar = scanner.next().charAt(0); // 오타 수정, 문자열 1개만 받음(++ -> +, +- -> +)

            System.out.print("두 번째 숫자 입력: ");
            //int number2 = scanner.nextInt();
            int number2 = safeNextInt(scanner, 2);

            try {
                OperatorType operation = OperatorType.fromChar(operationChar);
                // 사칙연산
                double result = calcul.calculate(number1, number2, operation);

                // operation으로 하면 Enum값으로 나옴 -> operation.getSymbol()
                System.out.println("결과 : " + number1 + " " + operation.getSymbol() + " " + number2 + " = " + result);

            } catch (Exception e) {
                System.out.println("예외처리(오류) : " + e.getMessage());
            }

            // history 확인 : 기록 수 제한(?)
            System.out.println("현재 기록 : " + calcul.getHistory());

            // 기타 기능 시험
            // Stream + Lambda : 특정 값보다 큰 결과 출력
            System.out.print("조회 기준값 입력: ");
            double standard = scanner.nextDouble();

            System.out.println(">> " + standard + "보다 큰 값들:");
            calcul.getGreaterThan(standard).forEach(System.out::println);

            // 종료 여부
            System.out.println("종료하시겠습니까? 예(1) / 아니오(아무 키)");
            String exc = scanner.next();

            if (exc.equals("예") || exc.equals("1")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }


        // 마무리
        scanner.close();
    }
}
