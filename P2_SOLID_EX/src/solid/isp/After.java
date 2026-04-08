package solid.isp;

//Phone에 대한 기본 기능만 제공
interface IPhone {
	 void call(String number); // 통화 기능
	 void message(String number, String text); // 문제 메세지 전송 기능
}

//충전기능
interface WirelessChargable {
	void wirelessCharge(); // 무선 충전 기능
}

//AR 기능
interface ARable {
	void AR(); // 증강 현실(AR) 기능
}

//생체 인식 기능 
interface Biometricsable {
	void biometrics(); // 생체 인식 기능
}

// 최신 기종  (다중 상속을 통해 지원하는 기능을 구현)
class S26 implements IPhone, WirelessChargable, ARable, Biometricsable {
	 public void call(String number) {
	 }
	
	 public void message(String number, String text) {
	 }
	
	 public void wirelessCharge() {
	 }
	
	 public void AR() {
	 }
	
	 public void biometrics() {
	 }
}

//구형
class S2 implements IPhone {
	public void call(String number) {
	}

	public void message(String number, String text) {
	}
}

public class After {
	
}
