package com.kh.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPclient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      
		// 요청하고자하는 서버의 위치를 알아야 함
		// ip + port 
	    String serverIP="192.168.10.37";
		int port = 3000;
		BufferedReader br =null;
		PrintWriter pw = null;
		try {
		Socket socket = new Socket(serverIP,port);
		
		if(socket != null) {
			System.out.println("연결성공");
			//입력용 스트림
			
			br = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			//출력용 스트림 
			pw = new PrintWriter(socket.getOutputStream());
			
			while(true) {
			System.out.print("서버로 보낼 내용 : ");
			String sendMessage = sc.nextLine();
			pw.println(sendMessage);
			pw.flush();
			
			String message = br.readLine();
			System.out.println("서버로부터전달받은 메세지 : " +message);
		}}
	}catch(IOException e) {
		e.printStackTrace();
	}

}}
