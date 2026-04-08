package solid.kiosk;

public class KioskApp {

	public static void main(String args[]) {
		
		// 주문: 메뉴 선택 -> 결제 -> 주문 내용 저장 -> 영수증 출력 
		Order order = new Order();
		
	    order.addItem("빅맥", 6500);
	    order.addItem("감자튀김(L)", 2500);
	    order.addItem("콜라(M)", 2000);
	
	    order.processPayment("CARD"); 	// 결제
	    order.saveToDatabase();       	// 저장
	    order.printReceipt();           // 출력
	}
}
