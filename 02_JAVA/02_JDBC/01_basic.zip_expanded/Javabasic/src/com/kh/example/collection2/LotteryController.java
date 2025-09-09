package com.kh.example.collection2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.kh.collection.set.Human;

public class LotteryController {
	private Set<Lottery> lottery = new HashSet<>();
	private Set<Lottery> win = new HashSet<>();
	

public boolean insertObject(Lottery l) {
    return lottery.add(l);  
    
}

public boolean deleteObject(Lottery l) {
	
	boolean isRemove = lottery.remove(l); 
	if(win != null && isRemove) {
		win.remove(l);
	}
	return isRemove;
}



public HashSet<Lottery> winObject(){
	 win.removeIf(l -> !lottery.contains(l));

	    // 2. 부족한 인원 수 계산
	    int need = 4 - win.size();

	    if (need > 0) {
	        // 3. lottery 에서 당첨자 후보 풀 생성 (이미 뽑힌 사람 제외)
	        List<Lottery> candidates = new ArrayList<>(lottery);
	        candidates.removeAll(win);

	        // 4. 랜덤 셔플 후 부족분만큼 뽑기
	        Collections.shuffle(candidates);
	        for (int i = 0; i < need && i < candidates.size(); i++) {
	            win.add(candidates.get(i));
	        }
	    }

	    // 5. 최종 당첨자 반환
	    return new HashSet<>(win);
}



public TreeSet<Lottery> sortedWinObject() {
    
    return new TreeSet<>(new SortedLottery()) {{
        addAll(win);
    }};
}




public boolean searchWinner(Lottery l) {
    return win.contains(l); 
}



















}



