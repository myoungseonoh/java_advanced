package oop.abstraction.practice;

// 필요한 기능만 정의, 상품을 결제하고자하는 절차에서는 내부 결제 프로세스는 몰라도 됨
interface Payment {

	void pay(int amount);
}

class NaverPayment implements Payment {

	@Override
	public void pay(int amount) {
		// 네이버 페이 결제 절차 
	}
}

class KakaoPayment implements Payment {

	@Override
	public void pay(int amount) {
		// 카카오 페이 결제 절차 
	}
}

class CreditCardPayment implements Payment {

	@Override
	public void pay(int amount) {
		// 신용카드 결제 절차 
	}
}

public class AbstractSample {

	public static void main(String[] args) {
		
		// 결제하기
		int totalPrice = 10000;
		int payType = 0; 
		
		//----------------------
		// Before
		// 다양한 결제수단 이용 가능
		if (payType == 0) {
			// 네이버 페이 결제 절차..
		} else if (payType == 1) {
			// 카카오 페이 결제 절차..
		} else if (payType == 2) {
			// 신용카드 결제 절차.. 
		}
		
		//----------------------
		// After
		Payment payment = null;
		
		// 다양한 결제수단 이용 가능
		if (payType == 0) {
			payment = new NaverPayment();
		} else if (payType == 1) {
			payment = new KakaoPayment();
		} else if (payType == 2) {
			payment = new CreditCardPayment();
		}	
		
		payment.pay(totalPrice);
	}
}
