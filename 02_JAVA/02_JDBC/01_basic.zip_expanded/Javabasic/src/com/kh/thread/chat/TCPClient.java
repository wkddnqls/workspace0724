package com.kh.thread.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
		 String serverIP="192.168.10.37";
			int port = 4000;
			
			try {
				Socket socket = new Socket(serverIP,port);
				if(socket !=null) {
					ClientReceive cr = new ClientReceive(socket); 
				cr.start();
				
				ClientSend cs = new ClientSend(socket);
				cs.start();
				}
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
