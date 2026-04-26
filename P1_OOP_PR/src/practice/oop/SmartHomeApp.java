package practice.oop;

import java.util.Scanner;

public class SmartHomeApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("\n 스마트홈 제어 시스템 시작..");
		
		// TODO.. 기기 등록.. 
		
		
		while (true) {
			
			/* TODO... 제어 가능한 모든 Device의 이름과 상태 출력하기 
			 * [1] [TV] (ON)
			 * [2] [Air Conditioner] (OFF)
			 * [3] [Light] (OFF)
			 */
        	
        	if (!selectDevice()) {
        		System.out.println("\n 스마트홈 제어 시스템 종료..");
        		return;
        	}
        }
	}
	
	// 등록된 모든 기기 및 상태 보기
	static void showAllDevices() {

		System.out.println("\n------------------------------");
		System.out.println("        스마트홈 기기 목록       ");
		System.out.println(" ------------------------------");
		
		System.out.println("현재 등록된 기기가 없습니다.");
		
		/* TODO 제어 가능한 모든 Device의 이름과 상태 출력하기 
		 * [1] [TV] (ON)
		 * [2] [Air Conditioner] (OFF)
		 * [3] [Light] (OFF)
		 */
		
//		int idx = readInt("\n  제어할 기기 번호 (0: 뒤로) > ");
//		if (idx == 0)
//			return;
	}
	
	// 선택된 기기 제어하기
	static boolean selectDevice() {
		int idx = readInt("\n  제어할 기기 번호 (0: 종료) > ");
        if (idx == 0) return false;
        
        System.out.println("To be implemented.");
        return true;
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
