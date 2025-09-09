package com.kh.pratice.array;

import java.util.Scanner;
/*
 * N개의 정수가 주어질 때, 이들 중 최솟값과 최댓값을 찾는 프로그램을 작성하세요
 */
public class Pratice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
   
		
		System.out.printf("숫자 입력 : ");
		int N =sc.nextInt();
		sc.nextLine();
		
		while (N < 1 || N >1000000) {
            System.out.println("범위가  이상해요 다시입력하세요.");
            System.out.printf("숫자 입력 : ");
    		N =sc.nextInt();
    		sc.nextLine();
        }
		
		
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
		
		int max = arr[0]; // Integer.MAX_VALUE // 인트로 표현할수있는 수는 가장 큰수
        int min = arr[0]; // Integer.MIN_VALUE // 인트로 표현할수있는 수는 가장 작은수
		
		
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] > max) {
                max =arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            
		}
		
		
		System.out.println("Min : "+min);
		System.out.println("Max : "+max);
		
		
		
		
		
		
		
		
		
		
		
	}

}
