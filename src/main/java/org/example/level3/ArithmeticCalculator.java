package org.example.level3;
import java.util.*;

public class ArithmeticCalculator <S> {
    public S calculator(S firstValue, S secondValue, OperatorType operatorType) {
        S result = null;
        String firstValueString = firstValue.toString();
        String secondValueString = secondValue.toString();
        int firstValueLength = firstValueString.length();
        int secondValueLength = secondValueString.length();
        Double resultDouble = null;

        if(!isNumber(firstValueLength, firstValueString) || !isNumber(secondValueLength, secondValueString))
            return null;

        Double firstValueDouble = Double.parseDouble(firstValueString);
        Double secondValueDouble = Double.parseDouble(secondValueString);

        switch(operatorType){
            case SUM:
                resultDouble = firstValueDouble + secondValueDouble;
                break;
            case SUB:
                resultDouble = firstValueDouble - secondValueDouble;
                break;
            case MUL:
                resultDouble = firstValueDouble * secondValueDouble;
                break;
            case DIV:
                if(secondValueDouble == 0)
                    return null;
                resultDouble = firstValueDouble / secondValueDouble;
                break;
            default:
                System.out.println("연잔자를 잘못 입력하셨습니다.");
        }
        

        return result;
    }

    public Boolean isNumber(int length, String string){
        int dat = 0;
        // 첫 번째 문자열을 받아 단순 문자열이거나 잘못된 숫자 일 시 혼내주기
        for(int i=0;i<length;i++){
            // 해당 인덱스의 문자가 숫자가 아니라면
            if(!Character.isDigit(string.charAt(i))){
                // 해당 인덱스의 문자가 '.' 이면서 dat이 1보다 작으면
                if(string.charAt(i)=='.' && dat<1){
                    dat++;
                    continue;
                }
                System.out.println("잘못된 값을 입력하셨습니다.");
                return null;
            }
        }
        return true;
    }

}
