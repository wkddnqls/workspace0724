package com.kh.thread.multi;

public class Task1 extends Thread{

	@Override
	public void run() {
		for(int i =1 ; i<=20 ; i++) {
			if(i%2 ==0 ) {
				System.out.print(i+" ");
			}
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//20이하의 짝수 출력
	
	

}
