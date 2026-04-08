package securecoding.crypto;

import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class CipherExcepiton extends Exception {
	public CipherExcepiton(String msg) {
		super(msg);
	}
}

public class CipherEx {

	static void printHex(String title, byte[] bytes) {

		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		System.out.println(title + "[" + bytes.length + "] = " + sb.toString());
	}
	
    public static byte[] generateRandom(int length) {
    	byte[] randomBytes = new byte[length];
    	SecureRandom secureRandom = new SecureRandom();
    	secureRandom.nextBytes(randomBytes);
    	return randomBytes;
    }

	static byte[] encrypt(String algName, String mode, String padding, int keybitlength) throws CipherExcepiton {
		
		String data = "01234567890123450123456789012345";		// 16byte 단위로 반박되는 평문
		String alg = algName + "/" + mode + "/" + padding;		// ex) AES/CBC/PKCS5Padding
		
		try {
			Cipher c = Cipher.getInstance(alg);

			System.out.println(alg + " [" + c.getBlockSize() + "]");

			byte[] key = generateRandom(keybitlength / 8);
			SecretKeySpec secretKeySpec = new SecretKeySpec(key, algName);
			
			if (mode.equals("ECB")) {
				c.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			}
			else {
				
				byte[] iv = generateRandom(c.getBlockSize());
				
				AlgorithmParameterSpec parameterSpec = null;
				
				if (mode.equals("GCM")) {
					 parameterSpec = new GCMParameterSpec(128, iv);
				} else {
					 parameterSpec = new IvParameterSpec(iv);
				}
				
				c.init(Cipher.ENCRYPT_MODE, secretKeySpec, parameterSpec);
			}

			return c.doFinal(data.getBytes());
		} catch (Exception e) {
			throw new CipherExcepiton(e.getMessage());
		}
	}
	
	public static void main(String[] args) {

		try {
			// 취약한 대칭키 알고리즘
			printHex("CipherText", encrypt("DES", "CBC", "PKCS5Padding", 64));		// 56bit 키, 브루트포스 가능
			printHex("CipherText", encrypt("DESede", "CBC", "PKCS5Padding", 192));	// 112bit 유효, 한계 도달
			printHex("CipherText", encrypt("AES", "ECB", "PKCS5Padding", 256));		// ECB 모드: 패턴 노출
			
			// [대칭키 암호화] AES-128/256 + CBC 또는 GCM 모드
			printHex("CipherText", encrypt("AES", "CBC", "PKCS5Padding", 256));		// ECB 모드: 패턴 노출
			printHex("CipherText", encrypt("AES", "GCM", "NoPadding", 256));		// 인증 암호화, 무결성 보장
			
			
		} catch (CipherExcepiton e) {
			e.printStackTrace();
		}
	
		// [비밀번호 해시] 반드시 솔트 + 반복 해시 
		// - 단순 SHA-256으로 패스워드 저장 금지 (레인보우 테이블 공격) 
//		MessageDigest md=MessageDigest.getInstance("SHA-256");
//		md.update(password.getBytes());
//		md.update(salt);
//		bytebyteData[]=md.digest();
	}

}

