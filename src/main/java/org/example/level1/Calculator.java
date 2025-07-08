package org.example.level1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        do {
            // 양의 정수(0 포함)를 입력받기
            System.out.print("첫 번째 값 입력: ");
            int firstValue = scanner.nextInt();
            System.out.print("두 번째 값 입력: ");
            int secondValue = scanner.nextInt();

            // 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
            System.out.print("사칙연산 입력: ");
            char ch = scanner.next().charAt(0);

            // 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
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
                        continue;
                    }
                    result = firstValue / secondValue;
                    break;
                default:
                    System.out.println("연잔자를 잘못 입력하셨습니다.");
                    continue;
            }
            System.out.println("결과: " + result);

            // 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지
            // 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            scanner.nextLine();
        } while(!scanner.nextLine().equals("exit"));
    }
}
