package securecoding.input;

public class CheckValidID {

	public static boolean isValidIdUsingBlacklist(String id) {

		System.out.print("ID:" + id + " ");
		
	    // 1. null 또는 길이 조건 검사 (4자 미만 거부)
	    if (id == null || id.length() < 4) {
	        return false;
	    }

	    // 2. 허용되지 않는 문자 검사
	    //    특수문자 블랙리스트: (_) 이외의 모든 문자
	    String blacklist = "!@#$%^&*()-+=[]{}|;':\",./<>?\\` ~";
	    for (char c : id.toCharArray()) {
	        boolean isUpperCase  = (c >= 'A' && c <= 'Z');
	        boolean isLowerCase  = (c >= 'a' && c <= 'z');
	        boolean isDigit      = (c >= '0' && c <= '9');
	        boolean isUnderline  = !(blacklist.indexOf(c) >= 0);

	        // 허용하지 않는 문자 발견
	        if (!isUpperCase && !isLowerCase && !isDigit && !isUnderline) {
	            return false; 
	        }
	    }

	    return true;
	}
	
	public static boolean isValidIDUsingWhiteList(String id) {

		System.out.print("ID:" + id + " ");
		
	    // 1. null 또는 길이 조건 검사 (4자 미만 거부)
	    if (id == null || id.length() < 4) {
	        return false;
	    }

	    // 2. 허용되지 않는 문자 검사
	    //    특수문자 화이트리스트: (_) 만 허용
	    for (char c : id.toCharArray()) {
	        boolean isUpperCase  = (c >= 'A' && c <= 'Z');
	        boolean isLowerCase  = (c >= 'a' && c <= 'z');
	        boolean isDigit      = (c >= '0' && c <= '9');
	        boolean isUnderline = (c == '_');

	        // 허용하지 않는 문자 발견
	        if (!isUpperCase && !isLowerCase && !isDigit && !isUnderline) {
	            return false; 
	        }
	    }

	    return true;
	}
	
	public static boolean isValidID(String id) {
		System.out.print("ID:" + id + " ");
	    return id != null && id.matches("^[a-zA-Z0-9_]{4,256}$");
	}
	
	public static void printResult(boolean r) {
		System.out.println(r? "(true) valid" : "(false) invalid");
	}
	
	public static void main(String[] args) {

		CheckValidID c = new CheckValidID();
	
		System.out.println(" -- BlackList");
		// 통과해야 하는 케이스
		printResult(isValidIdUsingBlacklist("user"));        // true  - 최소 길이
		printResult(isValidIdUsingBlacklist("User_123"));    // true  - 대소문자 + 숫자 + 언더스코어
		printResult(isValidIdUsingBlacklist("ABCD"));        // true  - 대문자만
		printResult(isValidIdUsingBlacklist("abcd1234"));    // true  - 소문자 + 숫자

		// 거부해야 하는 케이스
		printResult(isValidIdUsingBlacklist(null));          // false - null
		printResult(isValidIdUsingBlacklist("ab"));          // false - 길이 부족
		printResult(isValidIdUsingBlacklist("user@id"));     // false - @ 포함
		printResult(isValidIdUsingBlacklist("user name"));   // false - 공백 포함
		printResult(isValidIdUsingBlacklist("user-name"));   // false - 하이픈 포함
		printResult(isValidIdUsingBlacklist("user!!"));      // false - 특수문자 포함
		printResult(isValidIdUsingBlacklist("usℌr①"));      // false - 특수문자 포함
		
		System.out.println(" -- WhiteList");
		
		// 화이트리스트 (1)
		printResult(isValidIDUsingWhiteList("usℌr①"));      // false - 특수문자 포함
		
		// 화이트리스트 (2) -- 정규식(Regex. Regular Expression) 사용
		System.out.println(" -- WhiteList ");
		
		// 통과해야 하는 케이스
		printResult(isValidID("user"));        // true  - 최소 길이
		printResult(isValidID("User_123"));    // true  - 대소문자 + 숫자 + 언더스코어
		printResult(isValidID("ABCD"));        // true  - 대문자만
		printResult(isValidID("abcd1234"));    // true  - 소문자 + 숫자

		// 거부해야 하는 케이스
		printResult(isValidID(null));          // false - null
		printResult(isValidID("ab"));          // false - 길이 부족
		printResult(isValidID("user@id"));     // false - @ 포함
		printResult(isValidID("user name"));   // false - 공백 포함
		printResult(isValidID("user-name"));   // false - 하이픈 포함
		printResult(isValidID("user!!"));      // false - 특수문자 포함
		printResult(isValidID("usℌr①"));      // false - 특수문자 포함
	}
}
