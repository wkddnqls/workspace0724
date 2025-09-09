package solo.Test;

import java.util.Scanner;

public class gold {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		
		System.out.println("수를 입력하세요 : ");
		int n = sc.nextInt();
		
		if (n <= 2 || n % 2 != 0) {
            System.out.println("2보다 큰 짝수만 입력해야 합니다.");
            return; // 프로그램 종료
        }
		
		boolean found = false;
		
		for(int i =2 ; i<=n ; i++) {
			boolean a = true;
			boolean b = true;
			 
		        for(int j=2; j*j<=i; j++) {
		            if(i % j == 0) 
		            	a=false;
		            break;
		        }
		      
		        
		       int abc = n-i;
		       
		       for(int k=2; k*k<=abc; k++) {
		            if(abc % k == 0) 
		            	b=false;
		            break;
		        }
		        
		        
		        if(a && b ) {
		        	System.out.println(i+ "," +abc);
		        	found = true;
		        	break;
		        }
		        }	
			
		   if(!found) {
			   System.out.println("골드바흐 조합이 없습니다.");
		   }
		
		
		}

	}



   //    i N-i 
// 3 = 2+1
// 5 = 3+2 
// 8 = 3+5     
//10 = 5 + 5



