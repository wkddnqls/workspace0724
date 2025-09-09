package com.kh.pratice.array;

import java.util.Scanner;

public class Pratice4 {
/*
 * 학생 30명이 있고, 28명이 과제를 제출했습니다. 
 * 제출하지 않은 2명의 출석번호를 오름차순으로 출력하는 프로그램을 작성하세요. 
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        boolean[] submitted = new boolean[31]; // 인덱스 1~30 사용

        // 28명 제출
        for (int i = 0; i < 28; i++) {
            int num = sc.nextInt();
            submitted[num] = true; // 제출한 학생 표시
        }

        // 제출하지 않은 학생 출력 (오름차순)
        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) {
                System.out.println(i);
            }
        }
    		
		
	}

}
