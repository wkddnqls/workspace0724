package com.kh.copara;

import java.util.Comparator;

public class ScoreDescComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// 내림차순은 o2 vs o1
		return o2.score - o1.score;
	}
	

}
