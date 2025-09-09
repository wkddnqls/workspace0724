package com.kh.example.exception1;

public class CharacterController {

	public CharacterController() {
		super();
	}
   
	
	public int countAlpha(String s) throws CharCheckException{
		
		if (s.contains(" ")) {
			throw new CharCheckException("체크할 문자열에 공백검사했는데 있어");
		}
		
		int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                count++;
            }
        }
        return count;
	}
	
	
}
