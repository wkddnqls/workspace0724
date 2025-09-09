package com.kh.pratice.object;

public class Practice5_2 {
	
	
	public static boolean isGroupWord(String word) {
	        boolean[] visited = new boolean[26]; // 알파벳 사용 여부
	        char prev = 0; // 이전 문자 저장

	        for (int i = 0; i < word.length(); i++) {
	            char current = word.charAt(i);

	            // 이전 문자와 다르고, 이미 등장한 적이 있다면 그룹 단어 아님
	            if (current != prev && visited[current - 'a']) {
	                return false;
	            }

	            visited[current - 'a'] = true; // 현재 문자 방문 처리
	            prev = current; // 이전 문자 갱신
	        }

	        return true; // 끝까지 문제 없으면 그룹 단어
	    }
	}


