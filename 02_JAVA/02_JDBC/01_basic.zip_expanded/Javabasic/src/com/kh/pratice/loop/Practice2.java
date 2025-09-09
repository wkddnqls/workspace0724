package com.kh.pratice.loop;

import java.util.Scanner;
/*
 * 영수증에 적힌 **총 구매 금액**이 
 * 실제 구매한 각 물건의 **가격 × 개수 합계**와 일치하는지 확인하는 프로그램을 작성하세요.
   총액이 정확하면 `"Yes"`, 그렇지 않으면 `"No"`를 출력합니다.
 */
public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X; //영수증에 적힌 총 금액
		int N; // 구매한 물건의 종류수
	    int a; //물건의 가격
	    int b; //해당물건의 구매 개수
		int sum = 0;
		
		
		System.out.print("영수증에 적힌 금액 입력 : ");
		X = sc.nextInt();
		sc.nextLine();
		System.out.print("구매한 물건의 종류 수 (1~100): ");
		N = sc.nextInt();
		sc.nextLine();
      
		while (N < 1 || N > 100) {
            System.out.println("1 이상 100 이하로 입력하세요.");
            System.out.print("구매한 물건의 종류 수 (1~100): ");
            N = sc.nextInt();
            sc.nextLine();
        }
		
		
		
	for(int i = 1; i <= N; i++) {
		
		System.out.print("물건의 가격 (1~1000000): ");
		a = sc.nextInt();
		sc.nextLine();
		while (a < 1 || a > 1_000_000) {
            System.out.println("1 이상 1,000,000 이하로 입력하세요.");
            System.out.print("물건의 가격 (1~1000000): ");
            a = sc.nextInt();
            sc.nextLine();
        }
		
		 System.out.print("해당 물건의 구매 개수 (1~1000000): ");
         b = sc.nextInt();
         sc.nextLine();
         while (b < 1 || b > 1_000_000) {
             System.out.println("1 이상 1,000,000 이하로 입력하세요.");
             System.out.print("해당 물건의 구매 개수 (1~1000000): ");
             b = sc.nextInt();
             sc.nextLine();
         }
		
		System.out.println("해당 물건의 합산:" +a+"*" +b+ "=" +(a*b));
		sum += (a*b);
		}
	System.out.println("총 합산:"+sum);
	if(sum==X) {
		System.out.println("YES");
	}else {
		System.out.println("NO");
	}
	
	}

}
