package com.kh.example.gearrent;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class GearRentController {

	private HashMap<String, Device> catalog = new HashMap<>();      
    private HashMap<String, Member> members = new HashMap<>();      
    private HashMap<String, Loan> activeLoans = new HashMap<>();
    
    public boolean addDevice(Device device) {
        if(device == null || catalog.containsKey(device.getId())) {
        	return false;
        }
        catalog.put(device.getId(), device);  
        return true;
     
        
}
    public boolean addMember(Member member) {
        if (member == null || members.containsKey(member.getId())) {
            return false;
        }
        members.put(member.getId(), member);
        return true;
    }
    
    
    public Loan borrow(String memberId, String itemId, LocalDate today) {
    	if (!members.containsKey(memberId) || !catalog.containsKey(itemId)) {
            return null; 
        }
    	if (activeLoans.containsKey(itemId)) {
            return null; 
        }
		 
    	Device device = catalog.get(itemId);
    	int limitDays = device.getBorrowLimitDays();
    	LocalDate dueDate = today.plusDays(limitDays);
    	
    	Loan loan = new Loan ( itemId , memberId , today , dueDate);
    	activeLoans.put(itemId,loan);
    	
    	device.increaseBorrowCount();
        return loan;
    	
    }
    
    
    public int returnItem(String itemId, LocalDate today) {
    	Loan loan = activeLoans.get(itemId);
    	 if (loan == null) {
             return 0; 
         }
    	
    	 loan.setReturnedDate(today);
    	 int overdueDay = loan.overdueDays(today);
    	 
    	 Device device = catalog.get(itemId);
    	 
    	
    	activeLoans.remove(itemId);
        return device.calcLateFee(loan.overdueDays(today));
    }

    // 태그 검색
    public ArrayList<Device> findByTag(String tag) {
    	ArrayList<Device> result = new ArrayList<>();
    	if (tag == null) return result;
    	for (Device device : catalog.values()) {
            if (device.hasTag(tag)) {
                result.add(device);
            }
        }
        return result;
    }
    	
      
    

    // 키워드 검색 (이름 or 카테고리)
    public ArrayList<Device> findByKeyword(String keyword) {
        ArrayList<Device> result = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) return result;

        String lowerKeyword = keyword.toLowerCase();
        for (Device device : catalog.values()) {
            if (device.getName().toLowerCase().contains(lowerKeyword)
             || device.getCategory().toLowerCase().contains(lowerKeyword)) {
                result.add(device);
            }
        }
        return result;
    }

    // 전체 장비 조회 (읽기 전용 뷰)
    public Collection<Device> getAllDevices() {
        return catalog.values();
    }

    // 대여중 목록 조회 (읽기 전용 뷰)
    public Collection<Loan> getActiveLoans() {
        return activeLoans.values();
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
