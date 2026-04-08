package securecoding.crypto;

public class HardCoded {

	//  하드코딩 - 코드 저장소(Git)에 올라가는 순간 영구 노출
    private static final String DB_URL      = "jdbc:mysql://192.168.0.10:3306/prod";
    private static final String DB_USER     = "admin";
    private static final String DB_PASSWORD = "P@ssw0rd1234!"; // 소스코드에 평문
    
    private static final String API_SECRET  = "sk-abcd1234efgh5678"; // API 키도 마찬가지

	/*
	 * // 외부 환경에서 주입 받기 // 방법 1: 환경변수 (운영환경에서 가장 일반적) private static final String
	 * DB_PASSWORD = System.getenv("DB_PASSWORD");
	 * 
	 * // 방법 2: 외부 프로퍼티 파일 (application.properties, .env) // - 단, 해당 파일은 반드시
	 * .gitignore에 등록
	 * 
	 * // 방법 3: Vault, AWS Secrets Manager 등 시크릿 관리 서비스 static { if (DB_PASSWORD ==
	 * null || DB_PASSWORD.isBlank()) { throw new
	 * IllegalStateException("DB_PASSWORD 환경변수가 설정되지 않았습니다"); } }
	 */

}
