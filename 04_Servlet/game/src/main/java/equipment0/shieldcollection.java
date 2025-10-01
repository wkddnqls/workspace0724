package equipment0;

import java.time.LocalDateTime;

public class shieldcollection {
	private String shieldName;
	private int shieldNum;
	private String shieldInitiasl;
	private LocalDateTime shieldDate;
	private String shieldUse;
	
	public shieldcollection() {
		super();
	}

	public shieldcollection(String shieldName, String shieldInitiasl) {
		super();
		this.shieldName = shieldName;
		this.shieldInitiasl = shieldInitiasl;
	}

	public shieldcollection(String shieldName, int shieldNum, String shieldInitiasl, LocalDateTime shieldDate) {
		super();
		this.shieldName = shieldName;
		this.shieldNum = shieldNum;
		this.shieldInitiasl = shieldInitiasl;
		this.shieldDate = shieldDate;
	}

	public shieldcollection(String shieldName) {
		super();
		this.shieldName = shieldName;
	}

	public shieldcollection(String shieldName, int shieldNum, String shieldInitiasl, LocalDateTime shieldDate,
			String shieldUse) {
		super();
		this.shieldName = shieldName;
		this.shieldNum = shieldNum;
		this.shieldInitiasl = shieldInitiasl;
		this.shieldDate = shieldDate;
		this.shieldUse = shieldUse;
	}

	public String getShieldName() {
		return shieldName;
	}

	public void setShieldName(String shieldName) {
		this.shieldName = shieldName;
	}

	public int getShieldNum() {
		return shieldNum;
	}

	public void setShieldNum(int shieldNum) {
		this.shieldNum = shieldNum;
	}

	public String getShieldInitiasl() {
		return shieldInitiasl;
	}

	public void setShieldInitiasl(String shieldInitiasl) {
		this.shieldInitiasl = shieldInitiasl;
	}

	public LocalDateTime getShieldDate() {
		return shieldDate;
	}

	public void setShieldDate(LocalDateTime shieldDate) {
		this.shieldDate = shieldDate;
	}

	public String getShieldUse() {
		return shieldUse;
	}

	public void setShieldUse(String shieldUse) {
		this.shieldUse = shieldUse;
	}

	@Override
	public String toString() {
		return " 방패 종류 [ 방패 이름 = " + shieldName + ", 방패 강화 수치 = " + shieldNum + ", 방패 이니셜 ="
				+ shieldInitiasl + ", 방패 생성 일자 =" + shieldDate + ", 방패 사용처=" + shieldUse + "]";
	}
	
	
	
	
	
	
}
