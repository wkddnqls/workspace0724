package com.kh.pratice.array;

import java.util.Scanner;

public class Pratice1 {
 /*
  * 정수 N개로 이루어진 수열 A와 정수 X가 주어집니다. 
  * 이때, 수열 A에서 X보다 작은 수를 모두 입력된 순서대로 
  * 공백 한 칸으로 구분하여 출력하는 프로그램을 작성하세요. 
  */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		
		
		System.out.printf("숫자 입력 : ");
		N =sc.nextInt();
		sc.nextLine();
		
		while (N < 1 ) {
            System.out.println("1 이상 입력하세요.");
            System.out.printf("숫자 입력 : ");
    		N =sc.nextInt();
    		sc.nextLine();
        }
		System.out.printf("숫자 입력 : ");
		int X=sc.nextInt();
		sc.nextLine();
		
		while (X > 10000 ) {
            System.out.println("100000 이하 입력하세요.");
            System.out.printf("숫자 입력 : ");
    		X =sc.nextInt();
    		sc.nextLine();
        }  
		
		int[] arr = new int[N];
		
	        
		 for (int i = 0; i < N; i++) {
	            arr[i] = sc.nextInt();
	        }

	        for (int i = 0; i < N; i++) {
	            if (arr[i] < X) {
	                System.out.print(arr[i] + " ");
	            }
		
		
		
	}

	}}
