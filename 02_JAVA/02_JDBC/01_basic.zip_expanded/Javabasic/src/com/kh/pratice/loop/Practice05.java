package com.kh.pratice.loop;

import java.util.Scanner;

public class Practice05 {
/*
 * 사용자에게 정수를 반복 입력받아 **총합을 누적 계산**하는 프로그램을 작성하세요.
 * 단, **음수를 입력하면 입력을 종료**하고, 마지막에 누적된 총합을 출력하세요.
 * 
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int num;
		
		do {
			num =sc.nextInt();
					sum+=num;
					
		}while(num>=0);
		
		
		System.out.println("sum: "+sum);
	}

}

/*
 while(true)
 {
 System.out.print("숫자입력: ");
 int num = sc.nextInt();
 
 sum+=num;
 if(num <0)
 { break;
                }
                      }
 
 System.out.println("sum: "+sum);
 
 
  
  
  
  
 
*/