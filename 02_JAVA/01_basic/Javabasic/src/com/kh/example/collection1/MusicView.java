package com.kh.example.collection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicView {
	Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();

	public void mainMenu() {
		while(true) {
    System.out.println("***** 메인 메뉴 *****");
    System.out.println("1. 마지막 위치에 곡 추가");
    System.out.println("2. 첫 위치에 곡 추가 ");
    System.out.println("3. 전체 곡 목록 출력 ");
    System.out.println("4. 특정 곡 검색 ");
    System.out.println("5. 특정 곡 삭제 ");
    System.out.println("6. 특정 곡 정보 수정");
    System.out.println("7. 곡명 오름차순 정렬 ");
    System.out.println("8. 가수명 내림차순 정렬 ");
    System.out.println("9. 종료 ");
    System.out.println("메뉴 번호 입력 :  ");
   int a = sc.nextInt();
   sc.nextLine();
    
  switch(a) {
  case 1 :
	  addList();
	  break;
  case 2 :
	  addAtZero();
      break;
  case 3 :
	  printAll();
	  break;
  case 4 :
	  searchMusic();
	  break;
  case 5 :
	  removeMusic();
	  break;
  case 6 :
	  setMusic();
	  break;
  case 7 :
	  ascTitle();
	  break;
  case 8 :
	  descSinger();
	  break;
  case 9 :
	  System.out.println("프로그램 종료입니다. ");
	  return; 
  default :
	  System.out.println("잘못 입력하셨습니다 \n ");
  }

}
		
	}
	
	
		public void addList() {
			
			 System.out.println("-------마지막 위치에 곡 추가------");
			
			System.out.println("곡명 입력 : ");
			String a = sc.nextLine();
			
			
			System.out.println("가수명 입력 : ");
			String b = sc.nextLine();
	        
			int result = mc.addList(new Music(a,b));
			 
			if (result == 1) {
		            System.out.println("추가 성공");
		        } else {
		            System.out.println("추가 실패");
		        }
	
	      }
	
	
	
	public void addAtZero() {
		
	
		System.out.println("-------첫 위치에 곡 추가------");
	System.out.println("곡명 입력 : ");
	String a = sc.nextLine();
	sc.nextLine();
	
	System.out.println("가수명 입력 : ");
	String b = sc.nextLine();
    
	int result = mc.addAtZero(new Music(a,b));
	 
	if (result == 1) {
            System.out.println("추가 성공");
        } else {
            System.out.println("추가 실패");
        }

  }
	
	
	
	public void printAll() {
		mc.printAll();
		
		List<Music> list = new ArrayList<>();
		if (list.isEmpty()) {
            System.out.println("등록된 곡이 없습니다.");
            return;
        }

        System.out.println("==== 전체 곡 목록 ====");
        for (int i = 0; i < list.size(); i++) {
            Music m = list.get(i);
            System.out.println((i + 1) + ". " + m.getTitle() + " - " + m.getSinger());
        }
    }
	
	
	/*	
	if (list.isEmpty()) {
        System.out.println("등록된 곡이 없습니다.");
        return;
    }
		
		for(int i = 0 ; i<list.size(); i++) {
			   System.out.println(list.get(i));
		   }
     */
		
		
	 public void searchMusic() {
		 
		 
		 System.out.println("~~~~~~~~~~특정 곡 검색 ~~~~~~~ ");
		    System.out.println("곡명 입력 : ");
			String title = sc.nextLine();
			sc.nextLine();
	       Music m = mc.searchMusic(title);
	       if(m==null) {
	    	   System.out.println("검색한 곡이 없습니다.");
	       }else {
	    	   System.out.println("검색한 곡은" + m.toString() + "입니다.");
	       }
	        // 아니면 "검색한 곡은 가수 - 곡명 입니다." 출력(또는 VO toString)
	    }
	
	 public void removeMusic() {
		 System.out.print("삭제할 곡명: ");
	        String title = sc.nextLine();

	        Music removed = mc.removeMusic(title);

	        if (removed == null) {
	            System.out.println("삭제할 곡이 없습니다.");
	        } else {
	            System.out.println(removed.getSinger() + " - " 
	                               + removed.getTitle() + " 을(를) 삭제했습니다.");
	        }
	    }

	    public void setMusic() {
	    	System.out.print("수정할 기존 곡명: ");
	        String oldTitle = sc.nextLine();

	        System.out.print("새 곡명: ");
	        String newTitle = sc.nextLine();

	        System.out.print("새 가수명: ");
	        String newSinger = sc.nextLine();

	        Music updated = mc.setMusic(oldTitle, new Music(newTitle, newSinger));

	        if (updated == null) {
	            System.out.println("수정할 곡이 없습니다.");
	        } else {
	            System.out.println(
	                updated.getSinger() + " - " + updated.getTitle() + " 의 값이 "
	                + newSinger + " - " + newTitle + " 으로 변경되었습니다."
	            );
	        }
	    }

	    public void ascTitle() {
	    	int result = mc.ascTitle();
	        if (result == 1) {
	            System.out.println("정렬 성공 (곡명 오름차순)");
	        } else {
	            System.out.println("정렬 실패 (목록이 비어있습니다)");
	        }
	    }

	    public void descSinger() {
	    	  int result = mc.descSinger();
	    	    if (result == 1) {
	    	        System.out.println("정렬 성공 (가수명 내림차순)");
	    	    } else {
	    	        System.out.println("정렬 실패 (목록이 비어있습니다)");
	    	    }
	    }
	




}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	










































