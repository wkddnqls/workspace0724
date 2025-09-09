package com.kh.example.gearrent;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
	private String itemId ; // — 장비 ID

	private String memberId ; // — 회원 ID

	private LocalDate loanDate ;// — 대여일

	private LocalDate dueDate ; // 반납 예정일

	private LocalDate returnedDate = null; //실제 반납일(미반납 시 null)

	public Loan(String itemId, String memberId, LocalDate loanDate, LocalDate dueDate) {
		super();
		this.itemId = itemId;
		this.memberId = memberId;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
	}
	
	
	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public LocalDate getLoanDate() {
		return loanDate;
	}


	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public LocalDate getReturnedDate() {
		return returnedDate;
	}


	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}


	public boolean isOverdue(LocalDate today) {
		LocalDate referenceDate =null;
		if (returnedDate != null) {
	        referenceDate = returnedDate;
	    } else {
	        referenceDate = today;
	    }
		
		
		return referenceDate.isAfter(dueDate);
	}


	 public int overdueDays(LocalDate today) {
		 LocalDate referenceDate = null;
		    if (returnedDate != null) {
		        referenceDate = returnedDate;
		    } else {
		        referenceDate = today;
		    }

	        if (referenceDate.isAfter(dueDate)) {
	            int day = (int) ChronoUnit.DAYS.between(dueDate, referenceDate);
	            return day;
	        }
	        return 0;
	    }


	 @Override
	 public String toString() {
		return "Loan [itemId=" + itemId + ", memberId=" + memberId + ", loanDate=" + loanDate + ", dueDate=" + dueDate
				+ ", returnedDate=" + returnedDate + "]";
	 }




	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
