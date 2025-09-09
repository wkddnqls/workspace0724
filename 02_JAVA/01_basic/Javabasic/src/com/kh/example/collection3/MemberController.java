package com.kh.example.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MemberController {
    Map<String , Member> map = new HashMap<>();
   
    
    public boolean joinMembership(String id, Member m) {
        
    	if (map.containsKey(id)) {
            return false;
        }
        
        map.put(id, m);
        return true;
    }

   
    
    public String logIn(String id, String password) {
    	if (map.containsKey(id)) {
    		Member m = map.get(id);
          
    		if(m.getPassword().equals(password)){
        	   
        	   return m.getName();
           }
        }
       return null;
    }

   
    
    public boolean changePassword(String id, String oldPw, String newPw) {
    	 if (map.containsKey(id)) {
             Member m = map.get(id);
             // 기존 비밀번호가 맞으면 변경
             if (m.getPassword().equals(oldPw)) {
                 // setter가 필요함
                 m.setPassword(newPw);
                 return true;
             }
         }
         // 존재하지 않거나 비밀번호 불일치
         return false;
     
    }

   
    
    public void changeName(String id, String newName) {
    	 if (map.containsKey(id)) {
             Member m = map.get(id);
             m.setName(newName);
  
    	 }
    }
    	
    	
    	/*
          // 해당 id의 Member가 존재하면 이름을 newName으로 변경
        */
    

   
    
    public TreeMap<String, String> sameName(String name) {
          TreeMap<String, String> result = new TreeMap<>();
        
        for (Map.Entry<String, Member> entry : map.entrySet()) {
            String id = entry.getKey();
            Member m = entry.getValue();
            
            if (m.getName().equals(name)) {
                result.put(id, m.getName());
            }
        }
        
        return result;
    }
}
    

