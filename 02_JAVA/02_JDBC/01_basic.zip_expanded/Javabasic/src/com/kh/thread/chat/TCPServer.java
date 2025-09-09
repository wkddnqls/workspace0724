package com.kh.thread.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(4000);
			System.out.println("클라이언트 요청을 기다립니다.");
            Socket socket = server.accept();
            InetAddress clientIp = socket.getInetAddress();
            System.out.println(clientIp.getHostAddress() +"가 연결 요청");
			
            ServerReceive sr = new ServerReceive(socket);
            sr.start();
            
            ServerSend sc = new ServerSend(socket);
            sc.start();
            
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
}
