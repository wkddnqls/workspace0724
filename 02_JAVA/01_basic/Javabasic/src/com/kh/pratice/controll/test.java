package com.kh.pratice.controll;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        System.out.print("요일을 입력하세요 (월~일): ");
        String day = sc.nextLine();

        String category; // 어린이, 청소년, 성인
        double baseFee;

        // 나이 구간 분류
        if (age >= 0 && age <= 12) {
            category = "어린이";
            baseFee = 5000;
        } else if (age <= 18) { // 13~18
            category = "청소년";
            baseFee = 7000;
        } else if (age >= 19) {
            category = "성인";
            baseFee = 10000;
        } else {
            category = "잘못된 입력";
            baseFee = 0;
        }

        // 요일별 할인 적용
        boolean isWeekend = day.equals("토") || day.equals("일");
        boolean isWeekday = day.matches("월|화|수|목|금");

        if (!isWeekend && !isWeekday) {
            System.out.println("요일 입력이 잘못되었습니다.");
            return;
        }

        double finalFee = isWeekend ? baseFee * 0.8 : baseFee;

        // 출력
        System.out.printf("[%s 요금] %s (%.0f원)\n", category, isWeekend ? "주말 할인 적용" : "평일 요금", finalFee);
    }
}