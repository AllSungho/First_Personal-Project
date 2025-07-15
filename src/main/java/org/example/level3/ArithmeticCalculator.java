package org.example.level3;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ArithmeticCalculator <S> {
    public String calculator(S firstValue, S secondValue, OperatorType operatorType) {
        // 제네릭 타입 입력값을 문자열로 변환
        String firstValueString = firstValue.toString();
        String secondValueString = secondValue.toString();

        int firstValueLength = firstValueString.length();
        int secondValueLength = secondValueString.length();

        Double resultDouble = null;

        // 입력 받은 문자열에서 정수 또는 실수가 아닌 문자열일 시 null 반환
        if(!isNumber(firstValueLength, firstValueString) || !isNumber(secondValueLength, secondValueString))
            return null;

        // 문자열을 실수형으로 변환
        Double firstValueDouble = Double.parseDouble(firstValueString);
        Double secondValueDouble = Double.parseDouble(secondValueString);

        switch(operatorType){
            case SUM:
                System.out.println("덧셈: " + firstValueDouble + " + " + secondValueDouble);
                resultDouble = firstValueDouble + secondValueDouble;
                break;
            case SUB:
                System.out.println("뺄셈: " + firstValueDouble + " - " + secondValueDouble);
                resultDouble = firstValueDouble - secondValueDouble;
                break;
            case MUL:
                System.out.println("곱셈: " + firstValueDouble + " x " + secondValueDouble);
                resultDouble = firstValueDouble * secondValueDouble;
                break;
            case DIV:
                if(secondValueDouble == 0)
                    return null;
                System.out.println("나눗셈: " + firstValueDouble + " ÷ " + secondValueDouble);
                resultDouble = firstValueDouble / secondValueDouble;
                break;
            default:
                System.out.println("연잔자를 잘못 입력하셨습니다.");
        }

        return resultDouble.toString();
    }

    public Boolean isNumber(int length, String string){
        int dat = 0;
        // .. 입력 시 오류 발생
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

    public List moreBiggerResult(List<String> list, String currentResult){
        List<String> copy = new ArrayList<>(list.stream().map(num -> num.toString()).collect(Collectors.toList()));
        // 리턴이 리스트 내에 Boolean 형식으로 나옴
        return copy.stream().filter(num -> Double.parseDouble(num) > Double.parseDouble(currentResult)).map(num -> num).collect(Collectors.toList());
    }
}
