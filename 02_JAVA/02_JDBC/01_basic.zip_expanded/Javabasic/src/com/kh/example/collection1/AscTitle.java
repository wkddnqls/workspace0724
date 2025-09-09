package com.kh.example.collection1;

import java.util.Comparator;

public class AscTitle implements Comparator<Music> {

    @Override
    public int compare(Music o1, Music o2) {
        // 1차 기준: 제목(title) 오름차순
        int result = o1.getTitle().compareTo(o2.getTitle());

        // 2차 기준(보조 정렬): 제목이 같을 경우 가수(singer) 오름차순
        if (result == 0) {
            result = o1.getSinger().compareTo(o2.getSinger());
        }

        return result;
    }
}