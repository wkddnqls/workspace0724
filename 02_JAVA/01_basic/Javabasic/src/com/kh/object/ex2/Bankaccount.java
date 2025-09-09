package com.kh.object.ex2;

public class Bankaccount {
         int balance = 0;
         /*
          * 기본생성자 : 매개변수가 없는 생성자
          * - 생성자를 개발자가 정의하지 않으면 컴파일러가 자동으로 생성
          * - 생성자를 하나라도 정의하면 기본생성자는 생성되지않는다.
          */
         public Bankaccount() {
            System.out.println("생성자 실행됨.");
         }
         // 생성자 : 필드를 초기화하기 위한 특수목적의 메서드
         //        class와 이름이 동일하며, 반환타입이 없다
         public Bankaccount(int balnace) {
        	 this.balance = balance;
         }
         //입금
         void deposit(int amount) {
        	 balance += amount;
         }
         
         //출금
         void withdraw(int amount) {
        	 balance -= amount;
         }
         
         //잔액조회
         void checkMyBalnace() {
        	 System.out.println("잔액 : " + balance);
         }
         
         //계좌이체
         void transfer(Bankaccount target , int amount) {
        	 balance +=amount;
        	 target.balance -= 1000;
         }
         
         
         
         
         
         
         
         
         
         
         
}
