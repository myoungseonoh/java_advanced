package oop.polymorphism.ex.before;

class Card {
	public void pay(int amount) { /* 신용카드를 이용한 결제 프로세스 구현 */ }
}

class Cash {
	public void pay(int amount) { /* 현금을 이용한 결제 프로세스 구현 */	}
}

public class PayService {

	public void pay(String type, int amount) {
		
		if (type.equals("CARD")) { 
			Card card = new Card();
			card.pay(amount);
		} else if (type.equals("CASH")) {
			Cash cash = new Cash();
			cash.pay(amount);
		}
		// 결제수단 추가
		else {
			System.out.println("지원하지 않는 결제 방법입니다.");
		}
	}
	
	public static void main() {
		
		String paymethod = "";
		int total = 10000;
		
		// 결제 수단 선택 및 결제 금액 확인 절차....
		// 결제 수단 추가 시.. 
		/*
		 if ( ) { 		 paymethod = "CARD"; }
		 else if ( ) {	 paymethod = "CASH"; }
		 else if ( ) {	 paymethod = "KakaoPay"; }		// 결제수단 선택 창 추가
		 */
		PayService service = new PayService();
		service.pay(paymethod, total);
	}
}
