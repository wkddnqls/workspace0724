package com.kh.example.abstractNInterface;

public class V40 extends SmartPhone 
implements Phone, Camera, CellPhone, TouchDisplay, NotePen
{
	
	
	

	public V40() {
	super("LG");
}

	@Override
	public String touch() {
		// TODO Auto-generated method stub
		return "정전식";
	}

	@Override
	public boolean bluetoothPen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String charge() {
		// TODO Auto-generated method stub
		return "고속 충전, 고속 무선 충전";
	}

	@Override
	public String picture() {
		// TODO Auto-generated method stub
		return "1200, 1600만 트리플 카메라";
	}

	@Override
	public String takeCall() {
		// TODO Auto-generated method stub
		return "수신 버튼을 누름";
	}

	@Override
	public String makeCall() {
		// TODO Auto-generated method stub
		return "번호를 누르고 통화버튼을 누름";
	}
	
	public String printInformation() {
        return "V40 " + getMaker() + "에서 만들어졌고 제원은 다음과 같다.\n"
             + "- 터치 방식: " + touch() + "\n"
             + "- 블루투스 펜 지원: " + (bluetoothPen() ? "가능" : "불가능") + "\n"
             + "- 충전 방식: " + charge() + "\n"
             + "- 카메라: " + picture() + "\n"
             + "- 통화 수신: " + takeCall() + "\n"
             + "- 통화 발신: " + makeCall();
    }
}

