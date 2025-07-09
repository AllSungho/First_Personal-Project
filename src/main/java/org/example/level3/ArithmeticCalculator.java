package org.example.level3;

public class ArithmeticCalculator {
    public <T> T calculator(T firstValue, T secondValue, OperatorType operaterType) {
        T result = null;
        switch(operaterType){
            case SUM:
                result = firstValue + secondValue;
                break;
            case SUB:
                result = firstValue - secondValue;
                break;
            case MUL:
                result = firstValue * secondValue;
                break;
            case DIV:
                result = firstValue / secondValue;
                break;
            default:
                System.out.println("연잔자를 잘못 입력하셨습니다.");
        }

        return result;
    }
}
