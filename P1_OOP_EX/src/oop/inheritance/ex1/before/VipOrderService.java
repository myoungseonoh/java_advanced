package oop.inheritance.ex1.before;

import java.util.ArrayList;
import java.util.List;

class Order {

	String menu;
}

class OrderService {

	// (default) 같은 패키지의 (자식) 클래스에 노출
	List<Order> orders = new ArrayList<>();

	public void addOrder(Order order) {
		orders.add(order);
		logOrder(order); // 내부적으로 로깅
	}

	protected void logOrder(Order order) {
		System.out.println("주문 추가: " + order);
	}
}

//자식 클래스
public class VipOrderService extends OrderService {

	@Override
	public void addOrder(Order order) {
		// 부모의 orders 필드에 직접 접근 (강한 결합!)
		orders.add(0, order); // VIP 주문 맨 앞에 추가
		logOrder(order); // 부모의 메서드 호출
	}

}
