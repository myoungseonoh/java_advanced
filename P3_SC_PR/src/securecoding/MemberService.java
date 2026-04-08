package securecoding;

import java.util.HashMap;
import java.util.Map;

/**
 * 서비스 클래스
 */
public class MemberService {
	
    private final Map<String, Member> members = new HashMap<>();
    
    public void register(String email, String name, String password) {
        
        Member member = new Member(email, name, password);
        members.put(email, member);
    }
    
    public Member login(String email, String password) {
        
        Member member = members.get(email);
        
        if (member.isLocked()) {
            System.out.println("계정이 잠겼습니다. 관리자에게 문의하세요.");
            return null;
        }
        
        if (member.verifyPassword(password)) {
            return member;
        }
        
        System.out.println("남은 시도 횟수: " + member.getRemainingAttempts());
        return null;
    }
}
