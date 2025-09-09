package com.kh.pratice.array;

import java.util.Scanner;

public class Pratice6 {
 /*
  * 크기가 N × M인 두 정수 행렬 A, B가 주어질 때, 두 행렬의 원소별 합을 구해 출력하세요
  */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("행 입력 : "); 
        int N = sc.nextInt();
        System.out.printf("열 입력 : ");
        int M = sc.nextInt();
    
        if (N < 1 || N > 100 || M < 1 || M > 100) {
            System.out.println("N과 M은 1 이상 100 이하이어야 합니다.");
            return; // 프로그램 종료
        }
       
        int [][] A = new int [N][M];
        
        int [][] B = new int [N][M];
        
        
        for(int i =0 ; i<A.length;i++) {
			for(int j =0 ; j <A[i].length ; j++){
				
		        A[i][j] = sc.nextInt();
				
				
			}
		}
        
        for(int i =0 ; i<B.length;i++) {
			for(int j =0 ; j <B[i].length ; j++){
				
		        B[i][j] = sc.nextInt();
				
				
			}
		}
        
        
        
        for(int i =0 ; i<N;i++) {
			
        	for(int j =0 ; j <M ; j++){
			

				System.out.print((A[i][j] + B[i][j])+ " ");
				
			
			}
				System.out.println();
			
		
	}  sc.close();
        
        
        
        
	}

}
