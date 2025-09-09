package com.kh.example.gearrent;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public abstract class Device {
	private String id  ;// 장비 고유 ID (중복 불가)

	private String name;// 장비명

	private String category; //카테고리(예: "Camera", "Laptop")

	private int borrowCount ; // — 누적 대여 횟수

	private Set<String> tags; //  — 태그(중복 금지)
   
	public Device() {
		super();
	}

	public Device(String id, String name, String category, int borrowCount, Set<String> tags) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.borrowCount = 0;

       if (tags != null) {
            this.tags = new HashSet<>(tags);
        } else {
            this.tags = new HashSet<>();
        }
    }
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBorrowCount() {
		return borrowCount;
	}

	public void setBorrowCount(int borrowCount) {
		this.borrowCount = borrowCount;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	public abstract int getBorrowLimitDays();
	public abstract int calcLateFee(int overdueDays) ;
	
	
	
	public void increaseBorrowCount() { 
		borrowCount++;
		}
	
	public boolean hasTag(String tag) {
	   if ( tag == null ) { return false;}
	   
	   String n = tag.toLowerCase();
	   for (String t : tags) {
           if (t.toLowerCase().equals(n)) {
               return true;
           }
       }
       return false;
   }
	
	@Override
	public boolean equals(Object o) { 
		if (this == o) return true; 
		if (!(o instanceof Device)) 
			return false; 
		Device device = (Device) o;
		return Objects.equals(id, device.id); 
		}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 
                "" + id + '\'' +
                "" + name + '\'' +
               "" + category + '\'' +
              "" + borrowCount +
               "" + tags
        ;
}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

