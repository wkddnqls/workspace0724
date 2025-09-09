package com.kh.example.collection1;

import java.util.Objects;



public class Music {
 
	private String title;
	private String singer;
	
	public Music() {
		super();
	}

	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public int hashCode() {
		
		return Objects.hash(title,singer);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Music) {
		Music m = (Music)obj;
		return this.title.equals(m.getTitle()) && this.singer.equals(m.getSinger());
	}
		return false;
	}
	
	
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return singer + "-" +title;
	}

	 public int compareTo(Music other) {
	        // 기본 정렬 기준을 "제목(title) 오름차순"으로
	        return this.title.compareTo(other.title);
	    }
	
	
}
