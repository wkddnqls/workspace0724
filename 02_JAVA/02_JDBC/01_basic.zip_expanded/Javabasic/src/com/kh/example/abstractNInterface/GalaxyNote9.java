package com.kh.example.abstractNInterface;

public class GalaxyNote9 extends SmartPhone
implements Phone, Camera, CellPhone, TouchDisplay, NotePen
{

	
	
	public GalaxyNote9() {
        super("삼성");
    }

    @Override
    public String makeCall() {
        return "번호를 누르고 통화버튼을 누름";
    }

    @Override
    public String takeCall() {
        return "수신 버튼을 누름";
    }

    @Override
    public String picture() {
        return "1200만 듀얼 카메라";
    }

    @Override
    public String charge() {
        return "고속 충전, 고속 무선 충전";
    }

    @Override
    public String touch() {
        return "정전식, 와콤펜 지원";
    }

    @Override
    public boolean bluetoothPen() {
        return true;
    }

    @Override
    public String printInformation() {
        return "갤럭시 노트9은 " + getMaker() + "에서 만들어졌고 제원은 다음과 같다.\n"
             + "- 통화 발신: " + makeCall() + "\n"
             + "- 통화 수신: " + takeCall() + "\n"
             + "- 카메라: " + picture() + "\n"
             + "- 충전 방식: " + charge() + "\n"
             + "- 터치 방식: " + touch() + "\n"
             + "- 블루투스 펜 지원: " + (bluetoothPen() ? "가능" : "불가능");
    }
}
