package com.kh.example.inherit;

public class CircleController {

    // 필드: Circle 객체
    private Circle c = new Circle();

    // 면적 계산
    public String calcArea(int x, int y, int radius) {
        // 필드 초기화
        c.setX(x);
        c.setY(y);
        c.setRadius(radius);

        // 면적 공식 적용
        double area = Math.PI * radius * radius;

        // "x, y, radius / 면적" 형식으로 반환
        return c.getX() + ", " + c.getY() + ", " + c.getRadius() + " / " + area;
    }

    // 둘레 계산
    public String calcCircum(int x, int y, int radius) {
        // 필드 초기화
        c.setX(x);
        c.setY(y);
        c.setRadius(radius);

        // 둘레 공식 적용
        double circum = Math.PI * radius * 2;

        // "x, y, radius / 둘레" 형식으로 반환
        return c.getX() + ", " + c.getY() + ", " + c.getRadius() + " / " + circum;
    }
}

