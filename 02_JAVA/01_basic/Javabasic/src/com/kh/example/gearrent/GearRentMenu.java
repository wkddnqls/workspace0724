package com.kh.example.gearrent;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class GearRentMenu {

    private GearRentController gc = new GearRentController();
    private Scanner sc = new Scanner(System.in);

    // 메인 메뉴
    public void mainMenu() {
        while (true) {
            System.out.println("\n=== Gear Rent Menu ===");
            System.out.println("1. 장비 등록");
            System.out.println("2. 회원 등록");
            System.out.println("3. 대여");
            System.out.println("4. 반납");
            System.out.println("5. 태그 검색");
            System.out.println("6. 키워드 검색");
            System.out.println("7. 전체 장비 조회");
            System.out.println("8. 대여 중 목록 조회");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 1: addDevice(); break;
                case 2: addMember(); break;
                case 3: borrow(); break;
                case 4: returnItem(); break;
                case 5: findByTag(); break;
                case 6: findByKeyword(); break;
                case 7: printAllDevices(); break;
                case 8: printActiveLoans(); break;
                case 0: return;
                default:
                    System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
            }
        }
    }

    // 장비 등록
    private void addDevice() {
        try {
            System.out.print("유형 선택(1: Camera, 2: Laptop): ");
            int type = sc.nextInt();;
            sc.nextLine();
            
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("이름: ");
            String name = sc.nextLine();

            System.out.print("카테고리: ");
            String category = sc.nextLine();

            System.out.print("태그(쉼표로 구분): ");
            String tagLine = sc.nextLine();
            Set<String> tags = new HashSet<>();
           
            if (!tagLine.isBlank()) {
                String[] arr = tagLine.split(",");
                for (String t : arr) {
                    tags.add(t.trim());
                }
            }

            Device device ;
           
            if (type == 1) {
                device = new Camera(id, name, category, type, tags);
            } else if (type == 2) {
                device = new Laptop(id, name, category, type, tags);
            } else {
                System.out.println("잘못된 유형입니다.");
                return;
            }

            
            boolean added = gc.addDevice(device);
            
            if (added) {
                System.out.println("등록 완료");
            } else {
                System.out.println("중복된 ID입니다. 다시 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식이 올바르지 않습니다.");
        }
    }

    // 회원 등록
    private void addMember() {
        System.out.print("회원 ID: ");
        String id = sc.nextLine();
        System.out.print("회원 이름: ");
        String name = sc.nextLine();

        Member member = new Member(id, name);
        boolean added = gc.addMember(member);

        if (added) {
            System.out.println("회원 가입 완료");
        } else {
            System.out.println("중복된 ID입니다. 다시 입력해주세요.");
        }
    }

    // 대여
    private void borrow() {
       
            System.out.print("회원 ID: ");
            String memberId = sc.nextLine();

            System.out.print("장비 ID: ");
            String itemId = sc.nextLine();

            System.out.print("대여일(YYYY-MM-DD): ");
            LocalDate today = LocalDate.parse(sc.nextLine());
           
            Loan loan = gc.borrow(memberId, itemId, today);
           if(loan !=null) {
            System.out.println("대여 완료: " + loan);
            System.out.println("반납 예정일: " + loan.getDueDate());
           } else {
        	   System.out.println("대여 실패: 회원/장비 존재 여부 확인 또는 이미 대여 중일 수 있습니다.");
           }
           
    
   
    }

    // 반납
    private void returnItem() {
    	System.out.print("장비 ID: ");
        String itemId = sc.nextLine();

        System.out.print("반납일(YYYY-MM-DD): ");
        LocalDate today = LocalDate.parse(sc.nextLine());

        int fee = gc.returnItem(itemId, today);
        
        System.out.println("반납 완료. 연체료: " + fee + "원");
    }

    // 태그 검색
    private void findByTag() {
    	System.out.print("검색할 태그: ");
        String tag = sc.nextLine();
        
        ArrayList<Device> t = gc.findByTag(tag);
       
        if (t.isEmpty()) {
            System.out.println("결과 없음");
        } else {
            for (Device d : t) {
                System.out.println(d);
            }
        }
         
    	
    }

    // 키워드 검색
    private void findByKeyword() {
        System.out.print("검색 키워드: ");
        String keyword = sc.nextLine();

        List<Device> result = gc.findByKeyword(keyword);
        if (result.isEmpty()) {
            System.out.println("결과 없음");
        } else {
            for (Device d : result) {
                System.out.println(d);
            }
        }
    }
    
    
    // 전체 장비 조회
    private void printAllDevices() {
        Collection<Device> all = gc.getAllDevices();
        if (all.isEmpty()) {
            System.out.println("등록된 장비가 없습니다.");
        } else {
            for (Device d : all) {
                System.out.println(d);
            }
            
        }
    }
    

    // 대여 중 목록 조회
    private void printActiveLoans() {
        Collection<Loan> loans = gc.getActiveLoans();
        if (loans.isEmpty()) {
            System.out.println("대여 중인 장비가 없습니다.");
        } else {
            for (Loan l : loans) {
                System.out.println(l);
            }
        }
    }
}
