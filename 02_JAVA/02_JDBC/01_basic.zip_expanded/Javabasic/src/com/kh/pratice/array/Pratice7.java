package com.kh.pratice.array;

import java.util.Scanner;

public class Pratice7 {
/*
 * `N × M` 크기의 2차원 배열이 주어질 때, 
 * 배열에 포함된 **가장 큰 값**과 그 값이 위치한 **행 번호와 열 번호**를 출력하세요.
 * 행 번호와 열 번호는 1부터 시작**합니다.
 * 
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
        
        for(int i =0 ; i<A.length;i++) {
			for(int j =0 ; j <A[i].length ; j++){
				 
				int value = sc.nextInt();
				if (value < -1000 || value > 1000) {
	                    System.out.println("각 원소는 -1000 이상 1000 이하이어야 합니다.");
	                    return;
	                }
				
		        A[i][j] = value;
				
				
			}
		}
        
     
        int max = Integer.MIN_VALUE;
        int a=0;
        int b=0;
        
        
        
   for(int i =0 ; i<N;i++) {
			
        	for(int j =0 ; j <M ; j++){
			
             if(A[i][j] > max)
             {
            	 max = A[i][j];  
            	 a= i+1;
            	 b= j+1;
             }
				// System.out.print(A[i][j] + " ");
				
				
			
        	}
        	
        
        
        
	}
   
   
   
   
   System.out.println(max);
   System.out.println(a + "행" + b + "열");
   
   
   
   
   
   
   
}}
