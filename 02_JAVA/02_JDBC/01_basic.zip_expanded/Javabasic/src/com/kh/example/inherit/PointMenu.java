package com.kh.example.inherit;

import java.util.Scanner;

public class PointMenu {
	Scanner sc = new Scanner(System.in);
	CircleController cc = new CircleController();
	RectangleController rc = new RectangleController();
	
	
	
	
	public void mainMenu(){
		while (true) {
            System.out.println("===== 도형 프로그램 =====");
            System.out.println("1. 원");
            System.out.println("2. 사각형");
            System.out.println("9. 종료");
            System.out.print("메뉴 번호 : ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    circleMenu();
                    break;
                case 2:
                    rectangleMenu();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 선택하세요.");
            }
        }
    }
	 public void circleMenu() {
	        while (true) {
	            System.out.println("===== 원 메뉴 =====");
	            System.out.println("1. 원 둘레");
	            System.out.println("2. 원 넓이");
	            System.out.println("9. 메인으로");
	            System.out.print("메뉴 번호 : ");
	            int menu = sc.nextInt();

	            switch (menu) {
	                case 1:
	                    calcCircum();
	                    break;
	                case 2:
	                    calcCircleArea();
	                    break;
	                case 9:
	                    return; // 메인 메뉴로 복귀
	                default:
	                    System.out.println("잘못 입력하셨습니다.");
	            }
	        }
	    }

	    public void rectangleMenu() {
	        while (true) {
	            System.out.println("===== 사각형 메뉴 =====");
	            System.out.println("1. 사각형 둘레");
	            System.out.println("2. 사각형 넓이");
	            System.out.println("9. 메인으로");
	            System.out.print("메뉴 번호 : ");
	            int menu = sc.nextInt();

	            switch (menu) {
	                case 1:
	                    calcPerimeter();
	                    break;
	                case 2:
	                    calcRectArea();
	                    break;
	                case 9:
	                    return; // 메인 메뉴로 복귀
	                default:
	                    System.out.println("잘못 입력하셨습니다.");
	            }
	        }
	    }
	    
	    public void calcCircum() {
	        System.out.print("X 좌표 : ");
	        int x = sc.nextInt();
	        System.out.print("Y 좌표 : ");
	        int y = sc.nextInt();
	        System.out.print("반지름 : ");
	        int radius = sc.nextInt();

	        String result = cc.calcCircum(x, y, radius);
	        System.out.println("원의 둘레 : " + result);
	    }

	    public void calcCircleArea() {
	        System.out.print("X 좌표 : ");
	        int x = sc.nextInt();
	        System.out.print("Y 좌표 : ");
	        int y = sc.nextInt();
	        System.out.print("반지름 : ");
	        int radius = sc.nextInt();

	        String result = cc.calcArea(x, y, radius);
	        System.out.println("원의 넓이 : " + result);
	    }
	            
	            
	            
	    public void calcPerimeter() {
	    	System.out.print("X 좌표 : ");
	        int x = sc.nextInt();
	        System.out.print("Y 좌표 : ");
	        int y = sc.nextInt();
	        System.out.print("높이 : ");
	        int height = sc.nextInt();
	        System.out.print("너비 : ");
	        int width = sc.nextInt();
	    	
	    	String result = rc.calcPerimeter(x, y, height, width);
	    	System.out.println("사각형 둘레 : " + result);
	    	
	    	
	    	
		}
	    	
	    public void calcRectArea() {
	        System.out.print("x 좌표 : ");
	        int x = sc.nextInt();
	        System.out.print("y 좌표 : ");
	        int y = sc.nextInt();
	        System.out.print("높이 : ");
	        int height = sc.nextInt();
	        System.out.print("너비 : ");
	        int width = sc.nextInt();

	        String result = rc.calcArea(x, y, height, width);
	        System.out.println(result);
	    }  	
	    	
	    	
	    	



}
	




