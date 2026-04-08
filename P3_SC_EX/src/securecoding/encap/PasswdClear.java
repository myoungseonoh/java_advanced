package securecoding.encap;

import java.util.Arrays;

public class PasswdClear {

	void authenticate(String pw) {
		// 인증절차..
	}
	
	void authenticate(char[] pw) {
		// 인증절차
	}
	
	char[] getPasswordFromInput() {
		// 비밀번호에 대한 입력값을 char[] 형태로 반환
		return null;
	}

	public void clearMem1() {

		// String으로 비밀번호 관리 - String Pool에 남음, GC 시점 불확실
		String password = "secret123";
		authenticate(password);
		password = null; // 여전히 String Pool에 존재
	}

	public void clearMem2() {

		// char[]로 관리 - 사용 후 명시적 초기화 가능
		char[] password = getPasswordFromInput();
		try {
			authenticate(password);
		} finally {
			Arrays.fill(password, '\0'); // 메모리에서 즉시 제거
		}
	}
	
	public void clearMem3() {

		// 암호연산용 비밀키
		byte[] key = {	0x01, 0x03, (byte)0xAB, (byte)0xC2, (byte)0xA9, (byte)0x92, 0x12, 0x34, 
						0x54, 0x55, 0x53, 0x34, 0x34, (byte)0xB4, (byte)0xC1, 0x23 };
		try {
			// 암복호화 등 암호 연산 수행.. 
		} finally {
			Arrays.fill(key, (byte)0x00); // 메모리에서 즉시 제거
		}
	}
}
