package securecoding;

import java.util.regex.Pattern;

/**
 * 회원 클래스
 */
public class Member {
	
    private final String email;
    private String name;
    private String password;
    private int loginAttempts;
    private boolean locked;
    
    private int MAX_LOGIN_ATTEMPTS = 3;
    
    public Member(String email, String name, String password) {
        
        this.email = email;
        this.name = name;
        this.password = password;
        this.loginAttempts = 0;
        this.locked = false;
    }
    
    // Getter (필요한 것만)
    public String getEmail() { return email; }
    public String getName() { return name; }
    public boolean isLocked() { return locked; }
    
    // 비밀번호 검증 (내부 로직 캡슐화)
    boolean verifyPassword(String password) {
    	
    	if (this.password.equals(password)) {
    		return true;
    	}
    	
    	loginAttempts++;
        if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
            locked = true;
        }
        return false;
    }
    
    int getRemainingAttempts() {
        return MAX_LOGIN_ATTEMPTS - loginAttempts;
    }
}
