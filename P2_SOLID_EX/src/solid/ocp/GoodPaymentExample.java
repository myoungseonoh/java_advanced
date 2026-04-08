package solid.ocp;

/**
 * OCP 올바른 적용 (간단 버전)
 * 
 * 핵심: 새 결제 수단 추가 시 기존 코드 수정 없이 새 클래스만 추가
 */

// 1. 인터페이스 정의
interface Payment {
    void pay(int amount);
}

// 2. 기존 결제 수단 구현
class CardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("신용카드 결제: " + amount + "원");
    }
}

class CashPayment implements Payment {
    public void pay(int amount) {
        System.out.println("현금 결제: " + amount + "원");
    }
}

// 3. 기능 확장에 따라 Payment를 구현한 새로운 객체만 선언
class KakaoPayment implements Payment {
    public void pay(int amount) {
        System.out.println("카카오페이 결제: " + amount + "원");
    }
}

// 4. 결제 처리기 - 기능이 확장되어도 이 클래스는 수정할 필요 없음
class GoodPaymentProcessor {
    private Payment payment;
    
    // 인터페이스를 매개변수로 사용 (다형성 활용)
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    public void process(int amount) {
        payment.pay(amount);
    }
}

// 5. 실행
public class GoodPaymentExample {
    public static void main(String[] args) {
    	
        GoodPaymentProcessor processor = new GoodPaymentProcessor();
        
        // setPayment에 구현된 결재 클래스 객체만 전달하면 됨
        if (args[0].equals("CARD")) {
        	// 신용카드 결제
            processor.setPayment(new CardPayment());
        } else if (args[0].equals("CASH")) {
        	// 현금
        	processor.setPayment(new CashPayment());
        } else if (args[0].equals("KAKAO")) {		// 새로운 결재수단 추가
        	// 카카오결재
        	processor.setPayment(new KakaoPayment());
        }
        
        processor.process(Integer.parseInt(args[1]));
    }
}
