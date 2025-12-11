package calculatingstep3;

// 열거형
public enum OperatorType {
    ADD('+') {
        public double operate(double number1, double number2) {
            return number1 + number2;
        }
    },
    SUB('-') {
        public double operate(double number1, double number2) {
            return number1 - number2;
        }
    },
    MUL('*') {
        public double operate(double number1, double number2) {
            return number1 * number2;
        }
    },
    DIV('/') {
        public double operate(double number1, double number2) {
            if (number2 == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
            return number1 / number2;
        }
    };

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    // +, -, *, / 알맹이
    public char getSymbol() {
        return symbol;
    }

    // 각 Enum이 구현해야 하는 연산
    public abstract double operate(double number1, double number2);

    // 전달받은 char 기호로 Enum 찾아주는 정적 메서드
    public static OperatorType fromChar(char operation) {
        for (OperatorType type : values()) {
            if (type.symbol == operation) return type;
        }
        throw new IllegalArgumentException("연산자가 올바르지 않습니다: " + operation);
    }
}