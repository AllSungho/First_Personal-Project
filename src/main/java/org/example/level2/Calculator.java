package org.example.level2;

import java.util.*;

public class Calculator {
    // App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는
    // 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
    private int result;
    private Queue queue = new ArrayDeque();

    // 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
    public int calculator(int firstValue, int secondValue, char ch) {
        // 매개변수로 전달받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 리턴하기
        switch(ch){
            case '+':
                result = firstValue + secondValue;
                break;
            case '-':
                result = firstValue - secondValue;
                break;
            case '*':
                result = firstValue * secondValue;
                break;
            case '/':
                if(secondValue == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return 0;
                }
                result = firstValue / secondValue;
                break;
            default:
                System.out.println("연잔자를 잘못 입력하셨습니다.");
                return 0;
        }
        queue.add(result);

        System.out.println(queue);

        return result;
    }
    // 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
    public int getResult(){
        return result;
    }
    // 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드)
    public void setResult(int result){
        this.result = result;
    }
    // Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현
    public void removeResult(){
        queue.remove();
    }
    public Queue getQueue(){
        return queue;
    }
}
