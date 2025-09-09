package com.kh.pratice.loop;

import java.util.Scanner;

public class Practice08 {
/*
 * 사용자로부터 정수 N(1 ≤ N ≤ 20)을 입력받아, N층의 왼쪽 정렬된 별 피라미드를 출력하세요.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
   int N;
   System.out.print("N을 입력하세요 (1 ≤ N ≤ 20): ");
   N = sc.nextInt();
   while (N < 1 || N > 20) {
       System.out.print("잘못된 입력입니다. 다시 입력하세요: ");
       N = sc.nextInt();
   }
   for (int i = 1; i <= N; i++) { // i는 층 수
       for (int j = 1; j <= i; j++) { // j는 별 개수
           System.out.print("*");
       }
       System.out.println();
   
	}}

}




/*
   Scanner sc = new Scanner(System.in);
       
        int N;

        // 1~20 사이의 값 입력 (while로 검사)
        System.out.print("N을 입력하세요 (1 ≤ N ≤ 20): ");
        N = sc.nextInt();
       
        
        while (N < 1 || N > 20) {
            System.out.print("잘못된 입력입니다. 다시 입력하세요: ");
            N = sc.nextInt();
        }

        // 역피라미드 출력 (for문)
        
        
        for (int i = N; i >= 1; i--) { // i는 층 수 (큰 수 → 작은 수)
            for (int j = 1; j <= i; j++) { // j는 별 개수
                System.out.print("*");
            }
            System.out.println();
        }
  
  
  
  
 
  
  
  
  
 
*/