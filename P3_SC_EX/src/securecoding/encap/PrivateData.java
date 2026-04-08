package securecoding.encap;

import java.util.Arrays;

public class PrivateData {

    private String[] allowedIPs1 = {"192.168.1.1", "10.0.0.1"};
    private String[] allowedIPs2 = {"192.168.1.1", "10.0.0.1"};
    
    // 내부 배열을 그대로 반환 - 외부에서 내부 상태를 바꿀 수 있음
    public String[] getAllowedIPs() {
        return allowedIPs1; // 호출자가 allowedIPs[0] = "0.0.0.0" 가능!
    }
    
    // 복사
    public String[] getSafeAllowedIPs() {
    	return Arrays.copyOf(allowedIPs2, allowedIPs2.length);
    }
    
    public void printAllowedIPs1() {
    	
    	for (int i=0; i<allowedIPs1.length; i++) { 
    		System.out.println("[" + i + "] " + allowedIPs1[i]);
    	}
    }
    
    public void printAllowedIPs2() {
    	
    	for (int i=0; i<allowedIPs2.length; i++) { 
    		System.out.println("[" + i + "] " + allowedIPs2[i]);
    	}
    }
        
    public static void main(String[] args) {
    	
    	PrivateData p = new PrivateData();
    	
    	// -- CASE1
    	System.out.println("-- Before");
    	p.printAllowedIPs1();
    	String[] ips1 = p.getAllowedIPs();
    	
    	ips1[0] = "10.20.30.2";
    	
    	System.out.println("-- After");
    	p.printAllowedIPs1();
    	    	
    	// -- CASE2
    	System.out.println("-- Before");
    	p.printAllowedIPs2();
    	String[] ips2 = p.getSafeAllowedIPs();
    	
    	ips2[0] = "10.20.30.2";
    	
    	System.out.println("-- After");
    	p.printAllowedIPs2();
    	
    }
	
}
