package com.kh.example.poly2;

public class LibraryController {

	private Member mem = null;   // 명시적 null 초기화

    private Book[] bList = new Book[5];
    {
    bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
    bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
    bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
    bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
    bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
    }
    
    public void insertMember(Member mem) {
        this.mem = mem;
    }
    
    public Member myInfo() {
    	return mem;
    }
   
    public Book[] selectAll() {
    	
    return bList;
    	
    }

      // 문자열 1 . contains(문자열2) -> 문자열 1에 문자열 2가 포함되어잇다면 true / false;
    public Book[] searchBook(String keyword) {
        Book[] temp = new Book[bList.length];
        int count = 0;

        for (Book b : bList) {
            if (b != null && b.getTitle() != null && b.getTitle().contains(keyword)) {
                temp [count++] = b;
            }
        }
        
        return temp;
    }
    
    public int rentBook(int index) {
        int result = 0;  // 기본: 대여 성공

        Book selected = bList[index];

        if (selected instanceof AniBook aniBook) {
            if (mem.getAge() < aniBook.getAccessAge()) {
                result = 1;  // 나이제한으로 대여 불가
            }
        } else if (selected instanceof CookBook cookBook) {
            if (cookBook.isCoupon()) {
                mem.setCouponCount(mem.getCouponCount() + 1);
                result = 2;  // 대여 성공 + 쿠폰 발급
            }
        }

        return result;
    }

	
}


    

