package practice.oop;

import java.util.Scanner;

public class SmartHomeApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("\n 스마트홈 제어 시스템 시작");

		showAllDevices();
		
		while (true) {
			showMenu();
			
			int choice = readInt("  선택 > ");

			// Java14 +
			switch (choice) {
			case 1 -> selectDevice();
			case 0 -> {
				System.out.println("\n  시스템을 종료합니다.");
				return;
			}
			default -> System.out.println("  잘못된 입력입니다.");
			}
		}
	}

	// 메인 메뉴
	static void showMenu() {
		System.out.println("\n ------------------------------");
		System.out.println("   [1] 기기 선택 및 제어");
		System.out.println("   [0] 종료");
		System.out.println(" ------------------------------");
	}

	// 등록된 모든 기기 및 상태 보기
	static void showAllDevices() {

		System.out.println("\n------------------------------");
		System.out.println("        스마트홈 기기 목록       ");
		System.out.println(" ------------------------------");
		
		System.out.println("현재 등록된 기기가 없습니다.");
		
		/* TODO 제어 가능한 모든 Device의 이름과 상태 출력하기 
		 * [1] [거실 TV  ] 전원 : ON 상태 : 채널 1번 | 볼륨 30
		 * [2] [안방 에어컨] 전원 : OFF 상태 : 대기 중 (설정: 24도)
		 * [3] [주방 전등 ] 전원 : OFF 상태 : 꺼짐
		 */
		
//		int idx = readInt("\n  제어할 기기 번호 (0: 뒤로) > ");
//		if (idx == 0)
//			return;
	}
	
	// 선택된 기기 제어하기
	static void selectDevice() {
		System.out.println("To be implemented.");
	}
	
	
	// 숫자 입력 유틸
	static int readInt(String prompt) {
		System.out.print(prompt);
		while (!sc.hasNextInt()) {
			System.out.print("  숫자를 입력하세요 > ");
			sc.next();
		}
		return sc.nextInt();
	}
}
