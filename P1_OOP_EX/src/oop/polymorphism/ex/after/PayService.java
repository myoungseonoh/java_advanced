package oop.polymorphism.ex.after;

import java.util.Scanner;

interface Payment {
	void pay(int amount);
}

class Card implements Payment {
	public void pay(int amount) { /* 신용카드를 이용한 결제 프로세스 구현 */ }
}

class Cash implements Payment {
	public void pay(int amount) { /* 현금을 이용한 결제 프로세스 구현 */	}
}

public class PayService { 

	// 수정 사항 없음
	void pay(Payment p, int amount) {
		
		p.pay(amount);
	}
	
	public static void main() {
		
		Scanner scanner = new Scanner(System.in);
		
		Payment paymethod = null;
		
		// 결제 수단 선택 및 결제 금액 확인 절차....
		// 결제 수단 추가 시.. 
		int choice = Integer.parseInt(scanner.nextLine());
		int total = Integer.parseInt(scanner.nextLine());
		
		switch (choice) {
		case 0:
			paymethod = new Card();
			break;
		case 1:
			paymethod = new Cash();
			break;
		}
		
		PayService service = new PayService();
		service.pay(paymethod, total);
	}
}
