package com.kh.mybatis.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int boardNo;         // 게시글 번호
    private int categoryNo;      // 카테고리 번호 (FK)
    private String categoryName; // 카테고리명 (조인용)
    private String boardTitle;   // 제목
    private String boardContent; // 내용
    private int writerNo;        // 작성자 회원번호 (FK)
    
    private int count;           // 조회수
    private String createDate;   // 작성일
    private String status;       // 상태값(Y/N)

    private int boardType;
    private int boardWriter;
	
	private String memberId;

	private String thumbnailImg;

	
	
}
