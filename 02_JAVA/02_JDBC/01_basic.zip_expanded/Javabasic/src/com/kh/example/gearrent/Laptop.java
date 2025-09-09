package com.kh.example.gearrent;

import java.util.Set;

public class Laptop extends Device{

	
	
	public Laptop(String id, String name, String category, int borrowCount, Set<String> tags) {
		super(id, name, category, borrowCount, tags);
	}

	public Laptop() {
		super();
	}

	@Override
	public int getBorrowLimitDays() {
		// TODO Auto-generated method stub
		return 14;
	}

	@Override
	public int calcLateFee(int overdueDays) {
		// TODO Auto-generated method stub
		return overdueDays*500;
	}

}
