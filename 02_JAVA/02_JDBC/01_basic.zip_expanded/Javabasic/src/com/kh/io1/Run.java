package com.kh.io1;

import java.io.File;
import java.io.IOException;

public class Run {
/*
 * 간단하게 파일/폴더 생성 , 정보확인
 * java.io.File class를 이용하면 됨.
 * - 파일/폴더 경로를 표현하는 객체
 * 
 * 상대경로 : 지금내위치를 기반으로 다른경로를 탐색
 * 절대경로 : window -> C: ~ D:~ , Unix -> /root/~최상위 루트를 기준으로 다른경로를 탐색 
 * 
 */
	public static void main(String[] args) {
	   //1. 경로지정없이 파일객체를 생성 (상대경로 - 현재작업 폴더 기준 )
	
		File f1 = new File("test.txt");// 파일객체를 하나 생성 (실제파일 x - 코드로존재하는 파일객체) 
	  //2. 실제로 존재하는 경로에 파일생성 (절대경로)
		File f2 = new File("D:\\test.txt");
		//3. 존재하지 않는 경로에 파일 생성 
		File f3 = new File("D:\\tmp\\test.txt");

		try {
			f1.createNewFile(); // f1.createNewFile(); 시점에 실제파일이 만들어짐
			f2.createNewFile(); 
			// f3.createNewFile(); 존재하지않는 경로로 생성시 예외발생
			//폴더를 먼저 생성하고 파일이 맏늘어지게 해주면 됨.
			File tmpFolder = new File("D:\\\\tmp");
			tmpFolder.mkdir();
			f3.createNewFile();
			//파일정보 가져오기 
			File f4 = new File("ttt.txt");
			
			//파일 존재여부 확인  exists()
			System.out.println("exists : "+ f1.exists());
			System.out.println("exists : "+ f2.exists());
			
			// 파일유무확인 파일인지아닌지 isFile()
			System.out.println("isFile : "+ f1.isFile());
			System.out.println("exists : "+ tmpFolder.isFile());
			
			System.out.println("파일명 : " + f1.getName());
			System.out.println("파일경로 : "+ f1.getAbsoluteFile());
			System.out.println("파일용량 : "+ f1.length());
			System.out.println("파일상위폴더 : "+ f1.getParent());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
