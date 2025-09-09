package com.kh.example.poly1;


public class AnimalManager {

	public static void main(String[] args) {
		 // 크기 5인 Animal 배열
        Animal[] animals = new Animal[5];
        
        // Dog, Cat 객체 자유롭게 생성 저장
        animals[0] = new Dog(null, 0, "시베리안 허스키");
        animals[1] = new Cat(null, 0, "하얀색");
        animals[2] = new Dog(null, 0,"진돗개");
        animals[3] = new Cat(null, 0,"검은색");
        animals[4] = new Dog(null, 0, "푸들");
        
        // 향상된 for문으로 모든 동물 speak 호출
        for (Animal a : animals) {
            a.speak(); 
            
            // instanceof 활용
            if (a instanceof Dog) {
                Dog d = (Dog)a; 
                System.out.println("이 개의 견종은 " + d.getBreed() + "입니다.");
            } else if (a instanceof Cat) {
                Cat c = (Cat)a;
                System.out.println("이 고양이의 색상은 " + c.getColor() + "입니다.");
            }
            
            System.out.println("------------------");
        }
    }
}

