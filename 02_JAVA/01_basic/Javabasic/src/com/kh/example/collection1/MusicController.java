package com.kh.example.collection1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.clooection.list.Human;

public class MusicController {
	List<Music> list = new ArrayList<>();
	
	 public int addList(Music music) {
		 if (music == null) return 0;  
		 list.add(music); 
	        return 1;        
	    }
	
	 public int addAtZero(Music music) {
		 if (music == null) return 0;
		 list.add(0,music); 
	        return 1; 
	 }
	
	 public List<Music> printAll() {
	        return list; // 내부 리스트 그대로 반환
	    }
	
	 public Music searchMusic(String title) {
		 for (Music m : list) {
	            if (m.getTitle().equals(title)) {
	                return m;
	            }
	        }
	        return null; // 없으면 null
	    }
	 
    
     
	 public Music removeMusic(String title) {
		 for (Music m : list) {
	            if (m.getTitle().equals(title)) { 
	            	Music removMusic = m;
	            	list.remove(m);
	            	
	            	return removMusic;
	                
	            }
	        }
		   
	        return null;
	 }


	 public Music setMusic(String title, Music music) {
		 for (int i = 0; i < list.size(); i++) {
			 Music oldMusic = list.get(i); 
	            if (list.get(i).getTitle().equals(title)) {
	               
	                list.set(i, music);       
	                return oldMusic;             
	            }
	        }
		   
	        return null;
	 }
	 public int ascTitle() {
	        Collections.sort(list, new Comparator<Music>() {
	            @Override
	            public int compare(Music o1, Music o2) {
	                int result = o1.getTitle().compareTo(o2.getTitle());
	                if (result == 0) { // 제목이 같으면 가수명 오름차순
	                    result = o1.getSinger().compareTo(o2.getSinger());
	                }
	                return result;
	            }
	        });
	        return 1;
	    }

	    // ===== 가수명 내림차순 정렬 =====
	    public int descSinger() {
	        Collections.sort(list, new Comparator<Music>() {
	            @Override
	            public int compare(Music o1, Music o2) {
	                return o2.getSinger().compareTo(o1.getSinger()); // 내림차순
	            }
	        });
	        return 1;
	    }














}

