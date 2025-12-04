package calculatingstep1;

// 스캐너 클래스 가져오기
import java.util.Scanner;

public class CalculatorStep01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력한 순간부터 반복 : while(){}
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int number1 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요(add, sub, mul, div) : ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            String operation = sc.next();

            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int number2 = sc.nextInt();

            double result = 0;
            if (operation.equals("add")
                    || operation.equals("sub")
                    || operation.equals("mul")
                    || operation.equals("div")) {
                switch (operation) {
                    case "add":
                        result = number1 + number2;
                        break;
                    case "sub":
                        result = number1 - number2;
                        break;
                    case "mul":
                        result = number1 * number2;
                        break;
                    case "div":
                        if (number2 == 0) {
                            System.out.println("분모가 0일 수 없습니다.");
                            continue;
                            // 매서드 종료인 return으로 빼지 말고, 반복문 건너뛰는 용도인 continue 사용
                        }
                        // 출력은 실수로 해야하니 자료형 변환 (double)
                        result = (double) number1 / number2;
                        break;
                }
            } else {
                // 영어로 표기만 됨
                System.out.println("연산 기호를 다시 입력해주세요");
                continue;
                // 매서드 종료인 return으로 빼지 말고, 반복문 건너뛰는 용도인 continue 사용
            }
            // operation을 변환해서 원하는 기호를 출력할 수 있지만, 일단 생략
            System.out.println("결과 : " + number1 + " " + operation + " " + number2 + " = " + result);
            System.out.println("종료하시겠습니까? 예(1) / 아니오(아무 키)");
            String exc = sc.next();

            if (exc.equals("예") || exc.equals("1")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            // 별다른 예외 상황이 없으니 else{continue;} 생략함
        }// 반복문 종료
        
    }
}
