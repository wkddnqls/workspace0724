package com.kh.pratice.array;

import java.util.Scanner;

public class Pratice3 {
/*
 * N개의 바구니(1~N번)가 있고, M개의 공 넣기 작업이 주어집니다. 
 * 각 작업은 i번 바구니부터 j번 바구니까지 숫자 k가 적힌 공을 넣는 것을 의미합니다.
 *  그 후 각 바구니에 어떤 공이 들어 있는지 출력하세요. 공이 없는 경우 0으로 출력합니다.
 *   
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // N(바구니 개수)와 M(작업 개수) 입력
		System.out.printf("바구니 개수 입력 : ");
        int N = sc.nextInt();
        System.out.printf("공개수 입력 : ");
        int M = sc.nextInt();
        
        if (N < 1 || N > 100 || M < 1 || M > 100) {
            System.out.println("N과 M은 1 이상 100 이하이어야 합니다.");
            return; // 프로그램 종료
        }

        int[] basket = new int[N]; // 바구니 배열 (0으로 초기화)

        // M번 작업 수행
        for (int m = 0; m < M; m++) {
            int i = sc.nextInt(); // 시작 바구니
            int j = sc.nextInt(); // 끝 바구니
            int k = sc.nextInt(); // 공 번호
 
            if (i < 1 || j > N || i > j || k < 1 || k > N) {
                System.out.println("입력값이 조건에 맞지 않습니다.");
                return;
            }
            
            for (int b = i; b <= j; b++) {
                basket[b - 1] = k; // 바구니 번호는 1부터, 배열은 0부터 시작
            }
        }
     
        
        // 결과 출력
        for (int b = 0; b < N; b++) {
            System.out.print(basket[b] + " ");
        }
    }

}
