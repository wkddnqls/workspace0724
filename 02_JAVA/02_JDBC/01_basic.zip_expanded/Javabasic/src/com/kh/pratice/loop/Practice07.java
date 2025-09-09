package com.kh.pratice.loop;

public class Practice07 {
/*
 * `2단부터 9단까지`의 **구구단 전체를 출력**하는 프로그램을 작성하세요.
 *  각 단마다 `2 * 1 = 2` 형식으로 1부터 9까지 곱한 값을 출력합니다.
 */
	public static void main(String[] args) {
          
		
		
		for(int dan= 1 ; dan<10 ; dan++ ) {
			for(int i= 1 ; i<10 ; i++) {
			System.out.println(dan + "*" +i+ "=" +(dan*i));
		} if (dan==10) {
			break;
		}
		} 
	}

}
