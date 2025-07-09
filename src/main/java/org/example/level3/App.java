package org.example.level3;

import org.example.level2.Calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator cal = new ArithmeticCalculator();
        Objects result = null;
        OperatorType operatorType = null;

        do {
            // 양의 정수(0 포함)를 입력받기
            System.out.print("첫 번째 값 입력: ");
            Object firstValue = scanner.nextInt();
            System.out.print("두 번째 값 입력: ");
            Object secondValue = scanner.nextInt();

            // 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
            System.out.print("사칙연산 입력: ");
            char ch = scanner.next().charAt(0);

            switch(ch){
                case '+':
                    operatorType = OperatorType.SUM;
                    break;
                case '-':
                    operatorType = OperatorType.SUB;
                    break;
                case '*':
                    operatorType = OperatorType.DIV;
                    break;
                case '/':
                    operatorType = OperatorType.DIV;
                    break;
                default:
                    System.out.println("연산자를 잘못 입력하셨습니다.");
                    continue;
            }

            // firstValue와 secondValue가 String 타입일 시 해결 방법을 생각해야 함
            

            // Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
            System.out.println("결과: " + cal.calculator(firstValue, secondValue, operatorType));


            // 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지
            // 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            scanner.nextLine();
        } while(!scanner.nextLine().equals("exit"));
    }
}
