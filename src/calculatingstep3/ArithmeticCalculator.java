package calculatingstep3;

// 리스트
import java.util.ArrayList;
import java.util.List;

//람다 & 스트림
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    // 연산 결과 저장 리스트 : double로 저장
    private List<Double> history = new ArrayList<>();

    // Getter
    public List<Double> getHistory() {
        return history;
    }

    // Setter_도저히이거어따쓰는지모르겠다정말. getter이 있는데 setter을 어디에 써?
    // 작성한 거 지우는 용도로 쓰나?
    public void setHistory(List<Double> history) {
        this.history = history;
            // 최대 3개 유지
            while (this.history.size() > 3) {
                this.history.remove(0); // 가장 오래된 기록 삭제
            }
    }

    // 제네릭 타입(T)을 받아서 double로 변환해서 연산 수행
    public double calculate(T number1, T number2, OperatorType operator) {
        double num1 = number1.doubleValue();
        double num2 = number2.doubleValue();

        double result = operator.operate(num1, num2);

        // 연산 결과 저장
        history.add(result);
        // setter 통해 크기 관리
        setHistory(history);

        return result;
    }

    // 스트림 & 람다 사용: 특정 값보다 큰 결과만 조회
    public List<Double> getGreaterThan(double value) {
        return history.stream()
                .filter(x -> x > value) //큰놈만
                .collect(Collectors.toList());
    }
}