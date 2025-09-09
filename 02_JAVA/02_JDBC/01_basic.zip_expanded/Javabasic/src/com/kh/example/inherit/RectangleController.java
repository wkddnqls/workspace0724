package com.kh.example.inherit;

public class RectangleController {

    // 필드
    private Rectangle r = new Rectangle();

    // 면적 계산
    public String calcArea(int x, int y, int height, int width) {
        // r 필드 초기화
        r.setX(x);
        r.setY(y);
        r.setHeight(height);
        r.setWidth(width);

        int area = width * height;
        return r.getX() + ", " + r.getY() + ", " + r.getHeight() + ", " + r.getWidth()
                + " / " + area;
    }

    // 둘레 계산
    public String calcPerimeter(int x, int y, int height, int width) {
        // r 필드 초기화
        r.setX(x);
        r.setY(y);
        r.setHeight(height);
        r.setWidth(width);

        int perimeter = 2 * (width + height);
        return r.getX() + ", " + r.getY() + ", " + r.getHeight() + ", " + r.getWidth()
                + " / " + perimeter;
    }
}
