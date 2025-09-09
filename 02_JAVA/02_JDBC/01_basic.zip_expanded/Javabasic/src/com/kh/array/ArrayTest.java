package com.kh.array;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int j;
		
		//1. 크기가 10인 정수형 배열 생성
	    int[] arr1 = new int [10];
		//2. 반복문을 통해서 0번 인덱스부터 마지막 인덱스까지 10으로 초기화
		for(int i = 0 ; i<arr1.length;i++) {
			arr1[i]=10;
		}
		//3. for-each를 통해서 모든배열의 요소를 출력
		for(int num :arr1 ) {
			System.out.print(num+ " ");
		} 
		System.out.println();
		//4.사용자에게 배열의 길이를 입력받아, 해당크기의 문자열 strArr배열을 생성
		System.out.println("배열의 크기 입력 : ");
		j = sc.nextInt();
	    sc.nextLine();
		
	    String nameArr[]= new String [j];
	    
		//5. 사용자에게 사람의 이름을 입력받아 nameArr에 할당
		//   nameArr의 모든 요소만큼 실행.
       for (int i =0; i<nameArr.length;i++){
    	   System.out.print("이름 입력 : ");
   		          nameArr[i] = sc.next();
       }
       System.out.println(nameArr);
	    
       
	    
		// 6. 사용자에게 이름을 하나 입력받아, nameArr에 동일한 이름이 있다면
		// 동일한 이름이 존재합니다 / 동일한 이름이 존재하지 않습니다. 출력
		
       
       /*
       System.out.print("이름 : ");
          String A = sc.next();
       
        for(int n =0 ; n<nameArr.length ; n++) {
        	if(A.equals(n)) {
        		System.out.println("동일한 이름이 존재합니다.");
        		break;
        	}else if (n==(A.length()-1)) {
        		System.out.println("동인한 이름이 존재하지않습니다.");
        	}
        	
        }
    
       */ 
        
        
        
        
        System.out.print("이름 : ");
        String B = sc.next();
     
        
        boolean isDupl =false;
      for(String n : nameArr) {
      	if(B.equals(n)) {
      		isDupl = true;
      		break;
      	}}
      System.out.println
      (isDupl ?"동일한 이름이 존재합니다.":"동일한이름이 존재하지않습니다");
      	
     
	
	
	
	
	}
        
     }


