package proj.mini.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 절차 지향 프로그래밍 (Procedure Oriented Programming)
 */
public class AuthSystem {

	// 현재 로그인한 사용자
	private String currentUser;				// User -> Member, Operator

	// 가입된 사용자 정보 저장소
	Map<String, String> userRepository;		// Repository -> MemroyRepository (Map 사용)

	// 입력값 처리
	private final Scanner scanner;

	/**
	 * 기본 생성자
	 */
	public AuthSystem() {
		userRepository = new HashMap<String, String>();
		scanner = new Scanner(System.in);
	}

	public void run() {
		System.out.println("\n");
		System.out.println("══════════════════════════════════");
		System.out.println("     사용자 인증 및 계정 관리 시스템     ");
		System.out.println("══════════════════════════════════");

		boolean running = true;

		while (running) {

			// Guest
			if (currentUser == null) {
				running = handleGuest();
			}
			// User
			else {
				// Operator
				if (currentUser.equals("Admin")) {
					running = handleOperator();
				} else { // Member
					running = handleMember();
				}
			}
		}

		System.out.println("종료합니다.");
		scanner.close();
	}

	boolean handleGuest() {

		System.out.println("\n─── 메인 메뉴 ───");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("0. 종료");
		System.out.print("\n선택: ");

		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 0:
			return false;
		case 1:
			System.out.println("회원가입.");

			while (true) {
				System.out.print("ID 입력: ");
				String id = scanner.nextLine().trim();
				System.out.print("비밀번호 입력: ");
				String pw = scanner.nextLine().trim();

				userRepository.put(id, pw);
				break;
			}
			break;
		case 2:
			System.out.println("로그인.");

			while (true) {
				System.out.print("ID 입력: ");
				String id = scanner.nextLine().trim();
				
				System.out.print("비밀번호 입력: ");
				String pw = scanner.nextLine().trim();

				String userPw = userRepository.get(id);
				if (userPw == null) {
					System.out.println("존재하지 않는 ID 입니다..");
					continue;
				}
				if (!userPw.equals(pw)) {
					System.out.println("비밀번호가 틀렸습니다.");
					continue;
				}

				System.out.println("로그인 되었습니다.");
				currentUser = id;
				break;
			}

			break;
		default:
			System.out.println("잘못된 선택입니다.");
		}

		return true;
	}

	private boolean handleOperator() {

		System.out.println("\n─── 관리자 [" + currentUser + "] ───");
		System.out.println("1. 내 정보 보기");
		System.out.println("2. 비밀번호 변경");
		System.out.println("3. 이용자 현황");
		System.out.println("4. 이용자 인증 이력 조회");
		System.out.println("5. 로그아웃");
		System.out.println("0. 종료");
		System.out.print("\n선택: ");

		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 0:
			return false;
		case 1:
			System.out.println("내 정보 보기.");
			System.out.println("ID : " + currentUser);
			break;
		case 2:
			System.out.println("비밀번호 변경.");
			break;
		case 3:
			System.out.println("이용자");
			break;
		case 4:
			System.out.println("이용자 인증 이력 조회.");
			break;
		case 5:
			System.out.println("로그아웃.");
			currentUser = null; // 초기화
			break;
		default:
			System.out.println("잘못된 선택입니다.");
		}

		return true;
	}

	private boolean handleMember() {

		System.out.println("\n─── 이용자 메뉴 [" + currentUser + "] ───");
		System.out.println("1. 내 정보 보기");
		System.out.println("2. 비밀번호 변경");
		System.out.println("3. 로그아웃");
		System.out.println("0. 종료");
		System.out.print("\n선택: ");

		int choice = Integer.parseInt(scanner.nextLine().trim());
		switch (choice) {
		case 0:
			return false;
		case 1:
			System.out.println("내 정보 보기.");
			System.out.println("ID : " + currentUser);
			break;
		case 2:
			System.out.println("비밀번호 변경.");
			break;
		case 3:
			System.out.println("로그아웃.");
			currentUser = null; // 초기화
			break;
		default:
			System.out.println("잘못된 선택입니다.");
		}

		return true;
	}

	public static void main(String[] args) {
		AuthSystem system = new AuthSystem();
		system.run();
	}
}