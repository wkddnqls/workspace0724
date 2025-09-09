package com.kh.example.oop4;

import java.util.Scanner;

public class ShapeMenu {
	
	Scanner sc = new Scanner(System.in);
	SquareController scr = new SquareController();
	TriangleController tc = new TriangleController();
	
	
	public void inputMenu() {
		while (true){
			System.out.println("============ 도형 선택 메뉴 =============");
        System.out.println("3. 삼각형");
        System.out.println("4. 사각형");
        System.out.println("9. 종료");
        System.out.print("메뉴 번호 : ");
	
 	   int choice = sc.nextInt();
 	   sc.nextLine();
 	   
 	  switch(choice) {
 	  case 3:
          triangleMenu();  // 삼각형 메뉴 호출
          break;
      case 4:
          squareMenu();    // 사각형 메뉴 호출
          break;
      case 9:
    	  System.out.println("종료합니다");
         return;
      default:
    	  System.out.println("잘못입력했습니다 다시 입력해주세요");
    	  break;
           

		}
		}
	}
	
	
	
 	   public void triangleMenu() {
 		   while(true){
 		  System.out.println("=== 삼각형 메뉴 ===");
 	        System.out.println("1. 삼각형 넓이");
 	        System.out.println("2. 삼각형 색");
 	        System.out.println("3. 삼각형 정보 ");
 	       System.out.println("9. 메인으로");
 	        System.out.print("메뉴 번호 : ");
 	     
 	        int choice = sc.nextInt();
 	      sc.nextLine();
 	        
 	      
 	       switch(choice) {
 		   case 1 : 
 			  inputSize(3,2);
 	 		 break;
 		   case 2 : 
 			  inputSize(3,3);
 			 break;
 		   case 3 :
 			  printInformation(3);
 		    break;
 		   case 9 :
 			 return;
 		  default :
 			 System.out.println("다시입력하세요");
 			  
 	       }
 		   }
 		   
	}
 	   
 	   
	public void squareMenu() {
		while(true){
		System.out.println("=== 사각형 메뉴 ===");
	        System.out.println("1. 사각형 둘레");
	        System.out.println("2. 사각형 면적");
	        System.out.println("3. 사각형 색칠 ");
	       System.out.println("4. 사각형 정보");
	       System.out.println("9. 메인으로");
	        System.out.print("메뉴 번호 : ");
	       int choice = sc.nextInt();
	       sc.nextLine();
	       
	       switch(choice) {
 		   case 1 : 
 			  inputSize(4,1);
 	 		 break;
 		   case 2 : 
 			  inputSize(4,2);
 			 break;
 		   case 3:
 			  inputSize(4,3);
 		   case 4 :
 			  printInformation(4);
 		    break;
 		   case 9 :
 			
 			 return;
 		  default :
 			 System.out.println("다시입력하세요");
 			  
 	       }
 		   }
		
	}
	
	public void inputSize(int type , int menuNum) {
		//type 사각형 삼각형 둘중하나
		// menuNum -> 1 :둘레 , 2:넓이 3:색상
		
		
		switch(menuNum) {
		case 1 :
		{
			System.out.print("높이 : ");
			double height = sc.nextDouble();
			System.out.print("너비 : ");
			double width = sc.nextDouble();
            double perimeter = scr.calcArea(height, width);		
		    System.out.println("사각형의 둘레 : " +perimeter);
		} break;
		
		case 2:
		{
			System.out.print("높이 : ");
			double height = sc.nextDouble();
			System.out.print("너비 : ");
			double width = sc.nextDouble();
			double area ; 
			if (type == 3) {
			area = tc.calcArea(height, width);
			System.out.println("삼각 넓이 : " +area );
		}else  {                     
			area =scr.calcArea(height, width);
			System.out.println("사각 넓이 : " +area );
		} }break;
		
		case 3 :{
			System.out.print("색깔을 입력하세요 : ");
			String color = sc.next();
			sc.nextLine();
			
			if(type ==3)
				tc.paintColor(color);
			else
			scr.paintColor(color);
		}
		
		}
	}
	
	public void printInformation(int type) {
		  System.out.println(type==3 ? tc.print() : scr.print());  
		  }


}













/*
public void inputSize (int type, int menuNum) {
	  
 }
 public void printInformation(int type) {
	  System.out.println("");   }
 
*/