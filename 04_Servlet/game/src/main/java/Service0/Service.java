package Service0;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import JDBC.common;
import View0.viewMenu;
import enforce.program0.enforce00;
import equipment0.armorcollection;
import equipment0.equipmentcollection;
import equipment0.monstercollection;
import equipment0.shieldcollection;
import equipment0.swordcollection;

import static JDBC.common.*;


import Dao0.armorDao;
import Dao0.monsterDao;
import Dao0.shieldDao;
import Dao0.swordDao;



public class Service {
	 private swordDao sd = new swordDao();
	 private shieldDao SED = new shieldDao();
	 private armorDao AM = new armorDao();
private monsterDao MD = new monsterDao();
	private enforce00 ex = new enforce00();
   
	
	public equipmentcollection selectAll() {
	    Connection conn = common.go();

	    List<swordcollection> swords = sd.selectswordAll(conn);
	    List<shieldcollection> shields = SED.selectshieldAll(conn);
	   List<armorcollection> armor = AM.selectarmorAll(conn);
	   
	    close(conn);

	    return new equipmentcollection(swords, shields , armor);
	}


	public int insert(Object item) {
	    Connection conn = common.go();
	    int result = 0;

	    if (item instanceof swordcollection) {
	        result = sd.insertsword((swordcollection) item, conn);
	    } else if (item instanceof shieldcollection) {
	        result = SED.insertshield((shieldcollection) item, conn);
	    } else if (item instanceof armorcollection) {
	        result = AM.insertarmor((armorcollection) item, conn);
	    }

	    if (result > 0) {
	        commit(conn);
	    } else {
	        rollback(conn);
	    }
	    close(conn);

	    return result;
	}




	public int delete(Object item) {
		   Connection conn = common.go();
		    int result = 0;

		    if (item instanceof swordcollection) {
		        result = sd.deletesword((swordcollection) item, conn);
		    } else if (item instanceof shieldcollection) {
		        result = SED.deleteshield((shieldcollection) item, conn);
		    } else if (item instanceof armorcollection) {
		        result = AM.deletearmor((armorcollection) item, conn);
		    }

		    if (result > 0) {
		        commit(conn);
		    } else {
		        rollback(conn);
		    }
		    close(conn);

		    return result;
	 
}

	public equipmentcollection selectkeyword(Object item) {
	    Connection conn = common.go();
	    equipmentcollection result = new equipmentcollection();

	    if (item instanceof swordcollection) {
	        List<swordcollection> swords = sd.selectkeywordsword((swordcollection) item, conn);
	        result.setSwords(swords);
	    } else if (item instanceof shieldcollection) {
	        List<shieldcollection> shields = SED.selectkeywordshield((shieldcollection) item, conn);
	        result.setShields(shields);
	    } else if (item instanceof armorcollection) {
	        List<armorcollection> armors = AM.selectkeywordarmor((armorcollection) item, conn);
	        result.setArmor(armors);
	    }

	    close(conn);
	    return result;
	}

	public int update(Object item) {
	    Connection conn = common.go();
	    int result = 0;

	   
	        if (item instanceof swordcollection) {
	            swordcollection s = (swordcollection) item;
	            result = sd.updatesword(s, conn);
	        } else if (item instanceof shieldcollection) {
	            shieldcollection s = (shieldcollection) item;
	            result = SED.updateshield(s, conn);
	        } else if (item instanceof armorcollection) {
	        	armorcollection s = (armorcollection) item;
                result = AM.updatearmor(s, conn); }
	        
	        if (result > 0) {
	            commit(conn);
	        } else {
	            rollback(conn);
	        }

	        if (result > 0) {
		        commit(conn);
		    } else {
		        rollback(conn);
		    }
		    close(conn);

	    return result;
	}



public void enforceSword(String swordName) {
    Connection conn = common.go();

    
    swordcollection sword = sd.selectSword(swordName, conn);
   
    if(sword == null) {
        System.out.println("해당 소드를 찾을 수 없습니다.");
    }
    
    System.out.println("소드 이름: " + sword.getSwordName());
    System.out.println("현재 강화 수치: " + sword.getSwordNum());
    
    if(sword.getSwordNum() == 0) {
        ex.enforce0(swordName,1);
    } else if(sword.getSwordNum() == 1) {
        ex.enforce1(swordName,1);
    } else if(sword.getSwordNum() == 2) {
        ex.enforce2(swordName,1);
    } else if(sword.getSwordNum() == 3) {
        ex.enforce3(swordName,1);
    } else if(sword.getSwordNum() == 4) {
        ex.enforce4(swordName,1);
    } else if(sword.getSwordNum() == 5) {
        ex.enforce5(swordName,1);
    } else {
        System.out.println("강화 가능한 범위를 벗어났습니다.");
    }
    
    
    close(conn);
        return;
    }








public void enforceshield(String shieldName) {
Connection conn = common.go();


shieldcollection shield = SED.selectshield(shieldName, conn);

if(shield == null) {
    System.out.println("해당 소드를 찾을 수 없습니다.");
}

System.out.println("실드 이름: " + shield.getShieldName());
System.out.println("현재 강화 수치: " + shield.getShieldNum());

if(shield.getShieldNum() == 0) {
    ex.enforce0(shieldName,2);
} else if(shield.getShieldNum() == 1) {
    ex.enforce1(shieldName,2);
} else if(shield.getShieldNum() == 2) {
    ex.enforce2(shieldName,2);
} else if(shield.getShieldNum() == 3) {
    ex.enforce3(shieldName,2);
} else if(shield.getShieldNum() == 4) {
    ex.enforce4(shieldName,2);
} else if(shield.getShieldNum() == 5) {
    ex.enforce5(shieldName,2);
} else {
    System.out.println("강화 가능한 범위를 벗어났습니다.");
}


close(conn);
    return;
}

public void enforcearmor(String armorName) {
    Connection conn = common.go();

    
    armorcollection armor = AM.selectamor(armorName, conn);
   
    if(armor == null) {
        System.out.println("해당 소드를 찾을 수 없습니다.");
    }
    
    System.out.println("방어구 이름: " + armor.getArmorName());
    System.out.println("현재 강화 수치: " + armor.getArmorNum());
    
    if(armor.getArmorNum() == 0) {
        ex.enforce0(armorName,3);
    } else if(armor.getArmorNum() == 1) {
        ex.enforce1(armorName,3);
    } else if(armor.getArmorNum() == 2) {
        ex.enforce2(armorName,3);
    } else if(armor.getArmorNum() == 3) {
        ex.enforce3(armorName,3);
    } else if(armor.getArmorNum() == 4) {
        ex.enforce4(armorName,3);
    } else if(armor.getArmorNum() == 5) {
        ex.enforce5(armorName,3);
    } else {
        System.out.println("강화 가능한 범위를 벗어났습니다.");
    }
    
    
    close(conn);
        return;
    }














}
