package com.kh.example.inherit;

public class Rectangle extends Point {

    private int width;   // 너비
    private int height;  // 높이

    // 기본 생성자
    public Rectangle() {
        super();
    }

    // 좌표, 너비, 높이 초기화 생성자
    public Rectangle(int x, int y, int width, int height) {
        super(x, y); // Point의 생성자를 호출하여 x, y 설정
        this.width = width;
        this.height = height;
    }

    // width getter
    public int getWidth() {
        return width;
    }

    // width setter
    public void setWidth(int width) {
        this.width = width;
    }

    // height getter
    public int getHeight() {
        return height;
    }

    // height setter
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() +getX() + ", " + getY() + ", " + width + ", " + height;
    }
}
