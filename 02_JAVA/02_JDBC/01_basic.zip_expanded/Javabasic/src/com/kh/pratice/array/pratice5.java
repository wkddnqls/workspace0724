package com.kh.pratice.array;

import java.util.Scanner;

public class pratice5 {
/*
 * 1번부터 N번까지 번호가 순서대로 적힌 바구니가 있습니다.
 *  M개의 뒤집기 작업이 주어지며, 
 *  각각은 i번부터 j번 바구니의 순서를 역순으로 바꾸는 작업입니다. 
 * 모든 작업 후 최종 바구니의 번호 배열을 출력하세요.
 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
    
		System.out.printf("바구니 개수 입력 : "); 
        int N = sc.nextInt();
        System.out.printf("공개수 입력 : ");
        int M = sc.nextInt();
        
        if (N < 1 || N > 100 || M < 1 || M > 100) {
            System.out.println("N과 M은 1 이상 100 이하이어야 합니다.");
            return; // 프로그램 종료
        }
       
        int[] basket = new int[N]; // 바구니 배열 (0으로 초기화)
     for(int i =0 ; i<basket.length;i++) {
          basket[i]=i+1;
     }

        
        // M번 작업 수행
        for (int m = 0; m < M; m++) {
            int i = sc.nextInt(); // 시작 바구니
            int j = sc.nextInt(); // 끝 바구니 
            
            if (i < 1 || j > N || i > j || j> N) {
                System.out.println("입력값이 조건에 맞지 않습니다.");
                return;
            }
          
            int temp = basket[i-1];
            basket[i-1] = basket[j-1];
            basket[j-1] = temp;
            
            
        }
     
        
        // 결과 출력
        for (int b = 0; b < N; b++) {
            System.out.print(basket[b] + " ");
        }
    }


	
	
	
	
	
	
	
	}
	
