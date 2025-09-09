package com.kh.array;

import java.util.Scanner;

public class Arrat2DTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
	/*	
		
		//사용자에게 행(m)과 열(m)을 입력받아
		//해당 행과열의 빙고판을 만들어라.
		//다음 행과 열의 들어갈 문자를 각각 모두 입력받아 저장한 뒤
		// 출력해라
		
		/*
		 * 행: 2
		 * 열: 3
		 * 
		 * 1행1열 : 바나나
		 * 1행2열 : 배
		 * ...
		 * 2행3열 : 귤
		 * 
		 */
	 /* 
	  System.out.printf("헹 : ");
     int m = sc.nextInt();
	  sc.nextLine();
      
      System.out.printf("헹 : ");
      int n = sc.nextInt();
      
      String [][] arr = new String [m][n];



		for(int i =0 ; i<arr.length;i++) {
			for(int j =0 ; j <arr[i].length ; j++){
				
				System.out.printf("%d행 %d열: ",i+1,j+1);
		        arr[i][j] = sc.next();
				
				
			}
		}
		
		
		
		
		
			for(int i =0 ; i<arr.length;i++) {
				for(int j =0 ; j <arr[i].length ; j++){
				
	
					System.out.print(arr[i][j] + " ");
					
				
				}
					System.out.println();
				
			
		}
			*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		//사용자에게 좌석의 행과 열을 입력받아 2차원배열 생성
	    // 각 좌석에 들어갈 관객의 이름을 입력받아 저장한 뒤
	    //모두 입력받았으면 좌석표를 출력
	    // 행(줄)의 수 :
		// 열(좌석)의 수 :
		//1행1열: 철수~
		// ....
		// ======좌석표 ==========
		// 철수 민수 상수 ~~~
		
		
	
		System.out.printf("헹 : ");
	     int m = sc.nextInt();
	     sc.nextLine();
	     
	     System.out.printf("열 : " );
	     int n = sc.nextInt();
	     
	     String [][] arr = new String[m][n];
	     
	     
	     
	     for(int i =0 ; i<arr.length;i++) {
				for(int j =0 ; j <arr[i].length ; j++){
					
					System.out.printf("%d행 %d열: ",i+1,j+1);
			        arr[i][j] = sc.next();
					
					}
			}	 
	
	     System.out.println(" \n----------------좌석표--------------");
	
	     for(int i =0 ; i<arr.length;i++) {
				for(int j =0 ; j <arr[i].length ; j++){
				
	
					System.out.print(arr[i][j] + " ");
					
				
				}
					
				
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}



























