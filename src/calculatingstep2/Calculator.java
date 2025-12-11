// 사칙연산 클래스
// 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
package calculatingstep2;

// 연산 결과 저장 : ArrayList 필요
import java.util.ArrayList;
// 리스트 : List
import java.util.List;

public class Calculator {
    // 연산 결과 저장 리스트 : 이거 말고 getter이랑 setter 쓸 일 있나?
    // Double 타입 데이터를 담는 리스트 변수(history) 생성
    // 외부 접근 금지 : 필드변수 history
    private List<Double> history = new ArrayList<>();
    // getter : 필드 접근하여 가져옴
    public List<Double> getHistory() { return history; }
    // setter : 필드 접근하여 수정(return 없이 void로)
    // 아 진짜 이해 안가네. 이거 도대체 어디에 써?
    public void setHistory(List<Double> history) {
       this.history = history;
    }

    // 사칙연산
    // 더하기(add), 빼기(sub), 곱하기(mul), 나누기(div)
    public double add(int number1, int number2){
        double result = number1 + number2;
        history.add(result);
        return result;
    }

    public double sub(int number1, int number2){
        double result = number1 - number2;
        history.add(result);
        return result;
    }
    // 사칙연산
    public double mul(int number1, int number2){
        double result = number1 * number2;
        history.add(result);
        return result;
    }
    // 사칙연산
    public double div(int number1, int number2){
        // 분모 0 안됨
        if (number2 == 0){
            // 예외 발생 예제 : 3-1 의도하지 않은 에러 : ArithmeticException
            // throw new ArithmeticException("분모가 0일 수 없습니다.");
            // 예외발생 하면 그냥 꺼져버림. 이건 나중에 쓰자
            System.out.println("분모는 0이 될 수 없습니다.");
            return Double.NaN; // 계산 실패 표시;
        }

        double result = (double) number1 / number2;
        history.add(result);
        return result;
    }

}
