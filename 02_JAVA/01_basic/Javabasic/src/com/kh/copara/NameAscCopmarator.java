package com.kh.copara;

import java.util.Comparator;

public class NameAscCopmarator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// 으름차순
		return o1.name.compareTo(o2.name);
	}
      
	
	
	
	
	
	
	
	
}
