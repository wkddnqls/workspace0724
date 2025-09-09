package com.kh.example.abstractNInterface;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneController a = new PhoneController();
		String[] results = a.method();

        // 반복문으로 출력
        for (String info : results) {
            System.out.println(info);
            System.out.println("=================================="); // 구분선
        }

}}
