package equipment0;

import java.time.LocalDateTime;

public class armorcollection {
	private String armorName;
	private int armorNum;
	private String armorInitiasl;
	private LocalDateTime armorDate;
	private String armorUse;
	
	
	public armorcollection(String armorName) {
		super();
		this.armorName = armorName;
	}
	public String getArmorName() {
		return armorName;
	}
	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}
	public int getArmorNum() {
		return armorNum;
	}
	public void setArmorNum(int armorNum) {
		this.armorNum = armorNum;
	}
	public String getArmorInitiasl() {
		return armorInitiasl;
	}
	public void setArmorInitiasl(String armorInitiasl) {
		this.armorInitiasl = armorInitiasl;
	}
	public LocalDateTime getArmorDate() {
		return armorDate;
	}
	public void setArmorDate(LocalDateTime armorDate) {
		this.armorDate = armorDate;
	}
	public String getArmorUse() {
		return armorUse;
	}
	public void setArmorUse(String armorUse) {
		this.armorUse = armorUse;
	}
	public armorcollection() {
		super();
	}
	public armorcollection(String armorName, int armorNum, String armorInitiasl, LocalDateTime armorDate,
			String armorUse) {
		super();
		this.armorName = armorName;
		this.armorNum = armorNum;
		this.armorInitiasl = armorInitiasl;
		this.armorDate = armorDate;
		this.armorUse = armorUse;
	}
	public armorcollection(String armorName, String armorInitiasl) {
		super();
		this.armorName = armorName;
		this.armorInitiasl = armorInitiasl;
	}
	@Override
	public String toString() {
		return "방어구 [방어구 이름 =" + armorName + ", 방어구 강화 수치 =" + armorNum + ", 방어구 이니셜 = " + armorInitiasl
				+ ", 방어구 만든 날짜 = " + armorDate + ", 방어구 사용처 = " + armorUse + "]";
	}
}
