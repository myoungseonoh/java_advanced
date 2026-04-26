package oop.encapsulation.ex2;

public class Before {

	public String password;
	public int balance;
}

class TestBefore {
	
	void run() {
		Before b = new Before();
		b.password = "modify";		// 접근 및 수정 가능
		b.balance = 1000000;		// 접근 및 수정 가능
	}
}

