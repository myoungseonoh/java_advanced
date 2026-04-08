package securecoding.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswdEx {

//	final static String HASH_ALGORITHM = "SHA-256";
	final static String HASH_ALGORITHM = "SHA1";
	
	final static public void main(String[] arvg) {
		
		String passwd = "123123";
		digest(passwd);
//		for (int i=0; i<1; i++) {
			digestWithSalt(passwd);
//		}
	}
	
	// Salt를 이용한 비밀번호 해쉬값
	static void digestWithSalt(String passwd) {
		
		System.out.println("-- Digest with Salt -- ");
		byte[] salt = new byte[16];
		
		try {
			// JVM이 플랫폼에 맞는 최적의 알고리즘을 자동 선택
			SecureRandom secureRandom = new SecureRandom();
			secureRandom.nextBytes(salt);
			
			MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
			digest.update(salt);			
            byte[] hash = digest.digest(passwd.getBytes(StandardCharsets.UTF_8));
            
            System.out.println("Passwd = " + passwd);
            
            System.out.println("salt(b64) = " + Base64.getEncoder().encodeToString(salt));
            System.out.println("salt(hex) = " + hexEncoding(salt));
            
            String hashB64 = Base64.getEncoder().encodeToString(hash);
            String hashHex = hexEncoding(hash);
            System.out.println("BASE64[" + hashB64.length() + "] = " + hashB64);
            System.out.println("HEX   [" + hashHex.length() + "] = " + hashHex);
            
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("해싱 알고리즘을 사용할 수 없습니다: " + HASH_ALGORITHM, e);
        }
	}
		
	// Salt를 이용하지 않는 비밀번호 해쉬값
	static void digest(String passwd) {
		
		System.out.println("-- Digest -- ");
		byte[] salt = new byte[16];
		
		try {
			System.out.println("Passwd = " + passwd);
						
			MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
			byte[] hash = digest.digest(passwd.getBytes(StandardCharsets.UTF_8));
            
            String hashB64 = Base64.getEncoder().encodeToString(hash);
            String hashHex = hexEncoding(hash);
            System.out.println("BASE64[" + hashB64.length() + "] = " + hashB64);
            System.out.println("HEX   [" + hashHex.length() + "] = " + hashHex);
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("해싱 알고리즘을 사용할 수 없습니다: " + HASH_ALGORITHM, e);
        }
	}

	// JAVA 17+ 
	// String hexStr = HexFormat.of().formatHex(b);
	static public String hexEncoding(byte[] bytes) {
		
		StringBuilder sb = new StringBuilder();
	    
	    for(final byte b: bytes){
	        sb.append(String.format("%02x ", b & 0xff));
	    }
	    return sb.toString().replaceAll(" ", "");
	}
}
