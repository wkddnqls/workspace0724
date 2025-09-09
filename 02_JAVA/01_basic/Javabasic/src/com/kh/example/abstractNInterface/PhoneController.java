package com.kh.example.abstractNInterface;

public class PhoneController {
	 String[] result = new String[2];
	 
	  public  String[] method() {
		 
		  Phone[] phone = new Phone[2];
		  
		  phone[0] = new GalaxyNote9();  ;
		  
		  phone[1] = new V40();
		  
		  for(int i = 0 ; i<phone.length ; i++) {
			  
			  if(phone[i] instanceof GalaxyNote9)
			  {
				  result[i] = ((GalaxyNote9) phone[i]).printInformation();
			  } else if (phone[i] instanceof V40) {
	                result[i] = ((V40) phone[i]).printInformation();
			  
			  
		  }
		  
		  }
		  	  
		  
		  return result;
		 
	  }
	  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
