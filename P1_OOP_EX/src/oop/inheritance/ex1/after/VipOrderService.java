package oop.inheritance.ex1.after;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Order {

}

/**
 * 요구사항 : 주문목록을 List가 아닌 Map으로 변경 
 *  - Key: 0~10 까지는 VIP용으로 사용
 */
class OrderService {

	// (default) 같은 패키지의 (자식) 클래스에 노출
    List<Order> orders = new ArrayList<>();
 // List를 Map으로 변경하게 되면...
//	Map<Integer, Order> orders = new HashMap<>();	 
    
    public void addOrder(Order order) {
        orders.add(order);
//    	orders.put(orders.size(), order);
        logOrder(order);  // 내부적으로 로깅
    }
    
    protected void logOrder(Order order) {
        System.out.println("주문 추가: " + order);
    }
}

public class VipOrderService extends OrderService {

	@Override
    public void addOrder(Order order) {
		
        // 부모의 orders 필드에 직접 접근 (강한 결합!)
        orders.add(0, order);  // 맨 앞에 추가
//		orders.put(0, order);  // 맨 앞에 추가		// 수정필요!!
        logOrder(order);       // 부모의 메서드 호출
    }

}
