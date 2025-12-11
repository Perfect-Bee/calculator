package calculatingstep2;

import java.util.Scanner;
import java.lang.String;

public class CalculatorStep02 {
    public static void main(String[] args) {
        // 자동완성은 변수를 sc로 추천해주긴 하는데, 햇갈려서 scanner로 표기함
        Scanner scanner = new Scanner(System.in);
        // 같은 위치의 파일 Calculator.java 조합
        Calculator calc = new Calculator();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int number1 = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요(add(+), sub(-), mul(*), div(/)) : ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            char operation = scanner.next().charAt(0);
            // .charAt(0) 쓰려고 보니까 char은 원시형이라 .equals 못쓴다네
            // 아래 연산자에서 if case -> try switch로 바꾸기

            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int number2 = scanner.nextInt();

            double result = 0;
            // if switch말고 try switch가 더 깔끔함
            // default로 case 외 모든 걸 잘못된 연산자라고 하고, continue 하면 됨
            // result = switch()로 해도 default가 되는데, 일단 여기서는 이렇게 함
            // .charAt(0) 쓰려면 equals 못쓰는데? -> try로 바꾸자.
            // ? 아. "" 말고 '' 면 됨. ?>
            // ""이나 ''이나 같은 거 아니었냐구...
            try{
                switch (operation) {
                    case '+':
                        result = calc.add(number1, number2);
                        break;
                    case '-':
                        result = calc.sub(number1, number2);
                        break;
                    case '*':
                        result = calc.mul(number1, number2);
                        break;
                    case '/':
                        // 출력은 실수로 해야하니 자료형 변환 (double)
                        result = calc.div(number1, number2);
                        // 분모가 0이면 return Double.NaN
                        // NaN이면 true, 아니면 false : NaN이면 반복
                        if (Double.isNaN(result)) {
                            // continue로 반복문 처음으로 감
                            continue;
                        }
                        break;
                    default:
                        // +, -, *, / 아니면 전부 퇴출
                        System.out.println("잘못된 연산자입니다. 다시 입력하세요.");
                        continue;
                }
            } catch (Exception e) {
                System.out.println("예외처리(오류) : " + e.getMessage());
                continue;
            }
            System.out.println("결과 : " + number1 + " " + operation + " " + number2 + " = " + result);

            // history 확인
            System.out.println("지금까지의 계산 기록: " + calc.getHistory());

            System.out.println("종료하시겠습니까? 예(1) / 아니오(아무 키)");

            String exc = scanner.next();

            if (exc.equals("예") || exc.equals("1")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            // 별다른 예외 상황이 없으니 else{continue;} 생략함
        }
        
    }
}
