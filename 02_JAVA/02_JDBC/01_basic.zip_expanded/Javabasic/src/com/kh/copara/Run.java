package com.kh.copara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {
    /*
     *  - Comparable : 객체 스스로 기본 정렬 기준 제공
     *  - Comparator : 필요할 때 외부에서 정렬 기준 주입
     */
	public static void main(String[] args) {
	  List<Student> list = new ArrayList<>();
	  list.add(new Student("철수", 80 , 18));
	  list.add(new Student("민수", 90 , 15));
	  list.add(new Student("상수", 75 , 17));
	  list.add(new Student("지수", 75 , 16));
	  list.add(new Student("지수", 100 , 19));
	  list.add(new Student("여수", 80 , 18));
	  
	  System.out.println("최초 저장값 : ");
	  System.out.println(list);
	  
	  //Comparable : 학생에 정의된 기준으ㅗㄹ 정렬 (학생클래스에 compareTo 기준)
	  Collections.sort(list);
	  System.out.println("Comparable 정렬 후 : ");
	  System.out.println(list);
	  
	  
	  //Comparator :이름 오름차순
	  Collections.sort(list, new NameAscCopmarator());
	  System.out.println("Comparable 이름 오름차순 정렬 : ");
	  System.out.println(list);
	  
	  //Comparator :점수 내림차순
	  Collections.sort(list, new ScoreDescComparator());
	  System.out.println("Comparable 이름 오름차순 정렬 : ");
	  System.out.println(list);
	  
	  
	//Comparator :이름 , 점수 복합기준 정렬
	  Collections.sort(list, new ScoreDescAndNameAscComparator());
	  System.out.println("Comparable 점수 내림차순 ~ 이름 오름차순 복합기준 정렬 : ");
	  System.out.println(list);
	  
	}

}
