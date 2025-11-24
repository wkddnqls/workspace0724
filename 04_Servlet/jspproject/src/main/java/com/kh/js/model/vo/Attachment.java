package com.kh.js.model.vo;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * lombok은 자바에서 반복적으로 작성해야하는 코드를 자동으로 생성해주는 라이브러리이다
 * getter/setter , toString equals , hashCode
 * construcuctor 등...
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data



public class Attachment {
	private int fileNo;
	private int refBoardNo;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private int fileLevel;
	private String status;
}