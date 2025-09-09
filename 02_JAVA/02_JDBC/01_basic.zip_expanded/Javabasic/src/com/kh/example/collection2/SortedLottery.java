package com.kh.example.collection2;

import java.util.Comparator;



public class SortedLottery implements Comparator<Lottery>{

    public int compare(Lottery o1, Lottery o2) {
        // 1차 기준: 제목(title) 오름차순
        int result = o1.getName().compareTo(o2.getName());

        // 2차 기준(보조 정렬): 제목이 같을 경우 가수(singer) 오름차순
        if (result == 0) {
            result = o1.getPhone().compareTo(o2.getPhone());
        }

        return result;
    }
}

