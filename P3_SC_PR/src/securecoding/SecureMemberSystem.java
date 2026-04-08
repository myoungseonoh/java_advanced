package securecoding;

import java.util.*;

/**
 * 소규모 프로젝트
 * 회원 관리 시스템 만들기
 */
public class SecureMemberSystem {

    MemberService service = new MemberService();
    Scanner scanner = new Scanner(System.in);
    
    public void run() {
        
        System.out.println("=== 회원 관리 시스템 ===");
        
        while (true) {
            System.out.println("\n1. 회원가입  2. 로그인  3. 종료");
            System.out.print("선택: ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    registerMember();
                    break;
                case "2":
                    loginMember();
                    break;
                case "3":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("1, 2, 3 중에서 선택해주세요.");
            }
        }
    }
    
    private void registerMember() {
        try {
            System.out.print("이메일: ");
            String email = scanner.nextLine();
            
            System.out.print("이름: ");
            String name = scanner.nextLine();
            
            System.out.print("비밀번호: ");
            String password = scanner.nextLine();
            
            service.register(email, name, password);
            System.out.println("회원가입 성공!");
            
        } catch (IllegalArgumentException e) {
            System.out.println("가입 실패: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("가입 실패: " + e.getMessage());
        }
    }
    
    private void loginMember() {
        System.out.print("이메일: ");
        String email = scanner.nextLine();
        
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();
        
        Member member = service.login(email, password);
        
        if (member == null) {
        	System.out.println("로그인 실패");
        }
        else {
        	System.out.println("환영합니다, " + member.getName() + "님!");
        }
    }
    
    public static void main(String[] args) {
    	SecureMemberSystem s = new SecureMemberSystem();
    	s.run();
    }
}