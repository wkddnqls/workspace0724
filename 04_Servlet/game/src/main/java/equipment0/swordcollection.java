package equipment0;

import java.time.LocalDateTime;

public class swordcollection {
    private String equipName;       // SWORD_NAME
    private int equipNum;           // SWORD_NUM
    private String equipInitial;    // SWORD_INITIAL
    private LocalDateTime swordDate; // SWORD_DATE
    private String equipUse;        // SWORD_USE

    // 기본 생성자
    public swordcollection() {}

    // DB 저장용 생성자 (날짜 제외, DB에서 자동 입력됨)
    public swordcollection(String equipName, String equipInitial, int equipNum, String equipUse) {
        this.equipName = equipName;
        this.equipInitial = equipInitial;
        this.equipNum = equipNum;
        this.equipUse = equipUse;
    }
    public swordcollection(String equipName, String equipInitial, String equipUse) {
        this.equipName = equipName;
        this.equipInitial = equipInitial;
       
        this.equipUse = equipUse;
    }
    
    // 전체 생성자 (날짜까지)
    public swordcollection(String equipName, String equipInitial, int equipNum, LocalDateTime swordDate, String equipUse) {
        this.equipName = equipName;
        this.equipInitial = equipInitial;
        this.equipNum = equipNum;
        this.swordDate = swordDate;
        this.equipUse = equipUse;
    }

    // getter / setter
    public String getEquipName() { return equipName; }
    public void setEquipName(String equipName) { this.equipName = equipName; }

    public int getEquipNum() { return equipNum; }
    public void setEquipNum(int equipNum) { this.equipNum = equipNum; }

    public String getEquipInitial() { return equipInitial; }
    public void setEquipInitial(String equipInitial) { this.equipInitial = equipInitial; }

    public LocalDateTime getSwordDate() { return swordDate; }
    public void setSwordDate(LocalDateTime swordDate) { this.swordDate = swordDate; }

    public String getEquipUse() { return equipUse; }
    public void setEquipUse(String equipUse) { this.equipUse = equipUse; }

    @Override
    public String toString() {
        return "SwordCollection [equipName=" + equipName + 
               ", equipNum=" + equipNum + 
               ", equipInitial=" + equipInitial + 
               ", swordDate=" + swordDate + 
               ", equipUse=" + equipUse + "]";
    }
}
