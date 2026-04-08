package securecoding.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashEx {

	static void printHex(String algName, byte[] bytes) {
		
		StringBuilder sb = new StringBuilder();
	    for (byte b : bytes) {
	        sb.append(String.format("%02x", b));
	    }
	    System.out.println(algName + "[" + bytes.length + "] = " + sb.toString());
	}
	public static void main(String[] args) {
		
		String data = "test data";
		
		// 취약한 알고리즘 해시 알고리즘 - KISA/NIST 에서 사용 금지 또는 권고 중단
		MessageDigest md5 = null, sha1 = null, sha256 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			sha1 = MessageDigest.getInstance("SHA-1");  // 충돌공격 가능 (2017년 실증)
			sha256 = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    // 충돌공격 가능
				
		printHex("MD5", md5.digest(data.getBytes()));
		printHex("SHA1", sha1.digest(data.getBytes()));
		printHex("SHA256", sha256.digest(data.getBytes()));
	}
}
