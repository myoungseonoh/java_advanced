package oop.polymorphism.ex.after;

interface Payment {
	void pay(int amount);
}

class Card implements Payment {
	public void pay(int amount) { /* 신용카드를 이용한 결제 프로세스 구현 */ }
}

class Cash implements Payment {
	public void pay(int amount) { /* 현금을 이용한 결제 프로세스 구현 */	}
}

// 결제수단 추가
class KakaopPay implements Payment {
	
	public void pay(int amount) { /* 카카오페이을 이용한 결제 프로세스 구현 */	}
}

public class PayService { 

	// 수정 사항 없음
	void pay(Payment p, int amount) {
		
		p.pay(amount);
	}
	
	public static void main() {
		
		Payment paymethod = null;
		int total = 10000;
		
		// 결제 수단 선택 및 결제 금액 확인 절차....
		// 결제 수단 추가 시.. 
		/*
		 if ( ) { 		 paymethod = new Card(); }
		 else if ( ) {	 paymethod = new Cash(); }
		 else if ( ) {	 paymethod = new KakaoPay(); }		// 결제수단 선택 창 추가
		 */
		
		PayService service = new PayService();
		service.pay(paymethod, total);
	}
}
