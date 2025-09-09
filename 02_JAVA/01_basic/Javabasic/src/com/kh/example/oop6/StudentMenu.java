package com.kh.example.oop6;

public class StudentMenu {
	private StudentController sc;
    private final int CUT_LINE = 60; // 기준 점수

    public void StudentMenu() {
        sc = new StudentController();

        // 1. 학생 정보 출력
        System.out.println("=== 학생 정보 ===");
        for (Student s : sc.printStudent()) {
            System.out.println(s.inform());
        }
        /*
         *  Student[] sArr = sc.printStudent();
         *  for (int i = 0; i < students.length; i++) {
         *  System.out.println(students[i].inform());
         *    }
         *  
         */

        // 2. 성적 합계와 평균 출력
        double[] result = sc.avgScore();
        System.out.println("\n=== 성적 정보 ===");
        System.out.println("총합: " + result[0]);
        System.out.println("평균: " + result[1]);

        // 3. 성적 결과 출력
        System.out.println("\n=== 성적 결과 ===");
        for (Student s : sc.printStudent()) {
            String status = (s.getScore() < CUT_LINE) ? "재시험 대상" : "통과";
            System.out.println(s.getName() + " : " + status);
        }
    }

}