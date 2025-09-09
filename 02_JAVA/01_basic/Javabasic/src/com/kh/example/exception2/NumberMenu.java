package com.kh.example.exception2;

import java.util.Scanner;

public class NumberMenu {
	Scanner sc = new Scanner(System.in);
	NumberController controller = new NumberController();
	public void menu(){
		System.out.print("첫 번째 숫자 입력 : ");
        int num1 = sc.nextInt();

        System.out.print("두 번째 숫자 입력 : ");
        int num2 = sc.nextInt();
       
        try {
            boolean isMultiple = controller.checkDouble(num1, num2);
            if (isMultiple) {
                System.out.println(num1 + "는 " + num2 + "의 배수입니다. " +isMultiple);
            } else {
                System.out.println(num1 + "는 " + num2 + "의 배수가 아닙니다."  +isMultiple);
            }
        } catch (NumRangeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            
        }
    }
}



/*
 * boolean isCheck = nc.checkDouble(num1,num2);
 * System.out.printf("%d 는%d 의 배수인가 ? %s" , num1 , num2 , isCheck);
 */
