package securecoding.crypto;

import java.security.*;
import java.security.spec.*;
import java.util.Base64;

// ================================================================
// 교육용 전자서명 예제 - RSA vs ECC 비교
// ================================================================

public class DigitalSignatureEx {

	static void printHex(String title, byte[] bytes) {

		StringBuilder sb = new StringBuilder();
		
		int perLine = 0;
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
			perLine++;
			
		}
		System.out.println(title + "[" + bytes.length + "] = " + sb.toString());
	}
    // ────────────────────────────────────────────────────────────
    // 공통 유틸 - 바이트 배열을 읽기 좋게 출력
    // ────────────────────────────────────────────────────────────
    private static void printKeyInfo(String label, Key key) {
        System.out.println("\n[" + label + "]");
        System.out.println("  알고리즘  : " + key.getAlgorithm());
        System.out.println("  형식      : " + key.getFormat());
        printHex("  키 (Hex) ", key.getEncoded());
    }

    private static void printSignature(String label, byte[] signature) {
        System.out.println("\n[" + label + "]");
        System.out.println("  서명 길이  : " + signature.length + " bytes");
        printHex("  서명 (Hex) ", signature);
    }


    // ════════════════════════════════════════════════════════════
    // 1. RSA 전자서명
    // ════════════════════════════════════════════════════════════
    
    static final String ALG_RSA = "rSA";
    static final int ALG_RSA_KEY_BITS = 2048;		// KISA 권고: 2048bit 이상
    static final String ALG_RSA_SIGN = "SHA256withRSA";
    
    static final String ALG_ECC = "EC";
    static final String ALG_ECC_CURVE = "secp256r1";		// P-256 (NIST/KISA 권고)
    static final String ALG_ECDSA = "SHA256withECDSA";

    
    public static void rsaExample(String message) throws Exception {

        System.out.println("# RSA 전자서명 예제");
        System.out.println("  서명 대상 메시지: \"" + message + "\"");

        // ── Step 1. 키 쌍 생성 ───────────────────────────────────
        System.out.println("\n── Step 1. RSA 키 쌍 생성 (2048 bit) ──");

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(ALG_RSA_KEY_BITS, new SecureRandom());     
        KeyPair keyPair = keyGen.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();    // 서명에 사용 (절대 외부 노출 금지)
        PublicKey  publicKey  = keyPair.getPublic();     // 검증에 사용 (자유롭게 배포)

        printKeyInfo("RSA 개인키 (Private Key)", privateKey);
        printKeyInfo("RSA 공개키 (Public Key)",  publicKey);


        // ── Step 2. 전자서명 생성 ────────────────────────────────
        System.out.println("\n── Step 2. 전자서명 생성 (개인키로 서명) ──");

        Signature signer = Signature.getInstance(ALG_RSA_SIGN);
        signer.initSign(privateKey);                     // 개인키로 서명 초기화
        signer.update(message.getBytes());        // 서명할 데이터 입력
        byte[] signature = signer.sign();                // 서명 생성

        printSignature("RSA 서명값", signature);


        // ── Step 3. 전자서명 검증 ────────────────────────────────
        System.out.println("\n── Step 3. 전자서명 검증 (공개키로 검증) ──");

        Signature verifier = Signature.getInstance(ALG_RSA_SIGN);
        verifier.initVerify(publicKey);                  // 공개키로 검증 초기화
        verifier.update(message.getBytes());      	// 검증할 데이터 입력
        boolean isValid = verifier.verify(signature);    // 검증

        System.out.println("  원본 메시지 검증 결과: " + (isValid ? "Valid" : "Invalid"));


        // ── Step 4. 변조 시나리오 ────────────────────────────────
        System.out.println("\n── Step 4. 메시지 변조 후 검증 시도 ──");

        String tamperedMessage = message.replace(".", "?");
        Signature tamperedVerifier = Signature.getInstance(ALG_RSA_SIGN);
        tamperedVerifier.initVerify(publicKey);
        tamperedVerifier.update(tamperedMessage.getBytes()); // 변조된 메시지
        boolean isTamperedValid = tamperedVerifier.verify(signature);

        System.out.println("  변조 메시지: \"" + tamperedMessage + "\"");
        System.out.println("  변조 검증 결과: " + (isTamperedValid ? "Valid" : "Invalid"));
    }


    
    // ════════════════════════════════════════════════════════════
    // 2. ECC 전자서명 (ECDSA)
    // ════════════════════════════════════════════════════════════
    public static void eccExample(String message) throws Exception {

        System.out.println("# ECC 전자서명 예제 (ECDSA)");
        System.out.println("  서명 대상 메시지: \"" + message + "\"");

        // ── Step 1. 키 쌍 생성 ───────────────────────────────────
        System.out.println("\n── Step 1. ECC 키 쌍 생성 (P-256 곡선) ──");

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALG_ECC);
        ECGenParameterSpec ecSpec = new ECGenParameterSpec(ALG_ECC_CURVE); 
        keyGen.initialize(ecSpec, new SecureRandom());
        KeyPair keyPair = keyGen.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey  publicKey  = keyPair.getPublic();

        printKeyInfo("ECC 개인키 (Private Key)", privateKey);
        printKeyInfo("ECC 공개키 (Public Key)",  publicKey);


        // ── Step 2. 전자서명 생성 ────────────────────────────────
        System.out.println("\n── Step 2. 전자서명 생성 (개인키로 서명) ──");

        Signature signer = Signature.getInstance(ALG_ECDSA);
        signer.initSign(privateKey);
        signer.update(message.getBytes("UTF-8"));
        byte[] signature = signer.sign();

        printSignature("ECDSA 서명값", signature);


        // ── Step 3. 전자서명 검증 ────────────────────────────────
        System.out.println("\n── Step 3. 전자서명 검증 (공개키로 검증) ──");

        Signature verifier = Signature.getInstance(ALG_ECDSA);
        verifier.initVerify(publicKey);
        verifier.update(message.getBytes());
        boolean isValid = verifier.verify(signature);

        System.out.println("  원본 메시지 검증 결과: " + (isValid ? "Valid" : "Invalid"));


        // ── Step 4. 변조 시나리오 ────────────────────────────────
        System.out.println("\n── Step 4. 메시지 변조 후 검증 시도 ──");

        String tamperedMessage = message.replace(".", "?");
        Signature tamperedVerifier = Signature.getInstance(ALG_ECDSA);
        tamperedVerifier.initVerify(publicKey);
        tamperedVerifier.update(tamperedMessage.getBytes());
        boolean isTamperedValid = tamperedVerifier.verify(signature);

        System.out.println("  변조 메시지: \"" + tamperedMessage + "\"");
        System.out.println("  변조 검증 결과: " + (isTamperedValid ? "Valid" : "Invalid"));
    }


    // ════════════════════════════════════════════════════════════
    // 3. RSA vs ECC 성능 비교
    // ════════════════════════════════════════════════════════════
    public static void performanceComparison(String message) throws Exception {

        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║           RSA vs ECC 성능 비교 (100회 반복)            ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        int iterations = 100;

        // ── RSA 2048 성능 측정 ───────────────────────────────────
        KeyPairGenerator rsaGen = KeyPairGenerator.getInstance("RSA");
        rsaGen.initialize(2048, new SecureRandom());
        KeyPair rsaKeyPair = rsaGen.generateKeyPair();

        long rsaStart = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            Signature signer = Signature.getInstance("SHA256withRSA");
            signer.initSign(rsaKeyPair.getPrivate());
            signer.update(message.getBytes("UTF-8"));
            byte[] sig = signer.sign();

            Signature verifier = Signature.getInstance("SHA256withRSA");
            verifier.initVerify(rsaKeyPair.getPublic());
            verifier.update(message.getBytes("UTF-8"));
            verifier.verify(sig);
        }
        long rsaElapsed = System.currentTimeMillis() - rsaStart;


        // ── ECC P-256 성능 측정 ──────────────────────────────────
        KeyPairGenerator eccGen = KeyPairGenerator.getInstance("EC");
        eccGen.initialize(new ECGenParameterSpec("secp256r1"), new SecureRandom());
        KeyPair eccKeyPair = eccGen.generateKeyPair();

        long eccStart = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            Signature signer = Signature.getInstance("SHA256withECDSA");
            signer.initSign(eccKeyPair.getPrivate());
            signer.update(message.getBytes());
            byte[] sig = signer.sign();

            Signature verifier = Signature.getInstance("SHA256withECDSA");
            verifier.initVerify(eccKeyPair.getPublic());
            verifier.update(message.getBytes());
            verifier.verify(sig);
        }
        long eccElapsed = System.currentTimeMillis() - eccStart;


        // ── 결과 출력 ────────────────────────────────────────────
        System.out.println("\n  알고리즘          키 길이    서명값 크기    100회 서명+검증");
        System.out.println("  ─────────────────────────────────────────────────────");

        // RSA 서명값 크기 측정
        Signature rsaSigner = Signature.getInstance("SHA256withRSA");
        rsaSigner.initSign(rsaKeyPair.getPrivate());
        rsaSigner.update(message.getBytes());
        int rsaSigSize = rsaSigner.sign().length;

        // ECC 서명값 크기 측정
        Signature eccSigner = Signature.getInstance("SHA256withECDSA");
        eccSigner.initSign(eccKeyPair.getPrivate());
        eccSigner.update(message.getBytes());
        int eccSigSize = eccSigner.sign().length;

        System.out.printf("  %-16s  %6s     %6d bytes    %5d ms%n",
            "RSA",  "2048bit", rsaSigSize, rsaElapsed);
        System.out.printf("  %-16s  %6s     %6d bytes    %5d ms%n",
            "ECC (P-256)", "256bit",  eccSigSize,  eccElapsed);

        System.out.println("\n  ※ ECC는 RSA 대비 키 길이 1/8 수준으로 동급 보안강도 제공");
        System.out.println("  ※ IoT·모바일 등 자원 제약 환경에서 ECC가 유리한 이유");
        System.out.println("  ※ 단, RSA/ECC 모두 양자컴퓨터 앞에서는 취약 (→ PQC 전환 필요)");
    }

    // ════════════════════════════════════════════════════════════
    // Main
    // ════════════════════════════════════════════════════════════
    public static void main(String[] args) throws Exception {

        String message = "Hello, Java World.";

        rsaExample(message);
        System.out.println("\n─────────────────────────────────────────────────────");
        eccExample(message);
//        performanceComparison(message);
    }
}