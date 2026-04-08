package solid.ocp;

/**
 * OCP 위반 사례 (간단 버전)
 * 
 * 문제: 새로운 결제 수단 추가 시 이 클래스를 수정해야 함
 */
public class BadPaymentProcessor {
    
    public void pay(String type, int amount) {
        
    	if (type.equals("CARD")) {
            System.out.println("신용카드 결제: " + amount + "원");
        } 
        else if (type.equals("CASH")) {
            System.out.println("현금 결제: " + amount + "원");
        }
        // 카카오페이 추가하려면? → 기존 코드 수정 필요!
        // else if (type.equals("KAKAO")) {
        //     System.out.println("카카오페이 결제: " + amount + "원");
        // }
    }
    
    public static void main(String[] args) {
    	
    	String type = args[0];
    	int amount = Integer.parseInt(args[1]);
    	
        BadPaymentProcessor processor = new BadPaymentProcessor();
        
        processor.pay(type, amount);
        
    }
}
