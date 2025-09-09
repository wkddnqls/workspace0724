package equipment;

import java.time.LocalDateTime;

public class swordcollection {
private String swordName;
private int swordNum;
private String swordInitiasl;
private LocalDateTime swordDate;
private String swordUse;
public swordcollection() {
	super();
}

public swordcollection(String swordName) {
	super();
	this.swordName = swordName;
}

public String getSwordUse() {
	return swordUse;
}

public void setSwordUse(String swordUse) {
	this.swordUse = swordUse;
}

public swordcollection(String swordName, String swordInitiasl) {
	super();
	this.swordName = swordName;
	this.swordInitiasl = swordInitiasl;
}





public swordcollection(String swordName, int swordNum, String swordInitiasl, String swordUse) {
	super();
	this.swordName = swordName;
	this.swordNum = swordNum;
	this.swordInitiasl = swordInitiasl;
	this.swordUse = swordUse;
}

public swordcollection(String swordName, int swordNum, String swordInitiasl, LocalDateTime swordDate, String swordUse) {
	super();
	this.swordName = swordName;
	this.swordNum = swordNum;
	this.swordInitiasl = swordInitiasl;
	this.swordDate = swordDate;
	this.swordUse = swordUse;
}

public String getSwordName() {
	return swordName;
}

public void setSwordName(String swordName) {
	this.swordName = swordName;
}

public int getSwordNum() {
	return swordNum;
}

public void setSwordNum(int swordNum) {
	this.swordNum = swordNum;
}

public String getSwordInitiasl() {
	return swordInitiasl;
}

public void setSwordInitiasl(String swordInitiasl) {
	this.swordInitiasl = swordInitiasl;
}

public LocalDateTime getSwordDate() {
	return swordDate;
}

public void setSwordDate(LocalDateTime swordDate) {
	this.swordDate = swordDate;
}

@Override
public String toString() {
	return "소드의 종류 [소드 이름 = " + swordName + ", 소드 강화 수치 = " + swordNum + ", 소드 이니셜 = " + swordInitiasl
			+ ", 소드 생성날짜 = " + swordDate + ", 소드 사용처 =" + swordUse + "]";
}



}
