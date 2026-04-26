package oop.encapsulation.ex2;

public class After {

	private String password;
	private int balance;
	
	public After(String password, int balance) {
		this.password = password;
		this.balance = balance;
	}
	
	public void setPassword(String oldPasswd, String newPasswd) {
		if (!oldPasswd.equals(password)) {
			throw new IllegalArgumentException("인증 실패");
		}
		if (newPasswd.length() < 8) {
			throw new IllegalArgumentException("비밀번호 길이 8이상 필요");
		}

		password = newPasswd;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getBalance() {
		return balance;
	}
}

class TestAfter {
	
	void run() {
		// 객체 생성 시점에서 속성값 초기화
		After a = new After("passwd1234~!#", 10000);
//		a.password = "modify";		// 접근 불가
//		a.balance = 1000000;		
	}
}

