package securecoding.input;

class Request {
	
	static String getParameter(String param) {
//		return "5";
		return "-5";
//		return "100000000";
	}
}

public class IntOverflow {

	public static String[] createStrArray1() {
		
		String tmp = Request.getParameter("msg_param_num");

		// 외부 입력값을 정수형으로 사용할 때 입력값의 크기를 검증하지 않고 사용
		int param_ct = Integer.parseInt(tmp);
		return new String[param_ct];
	}
	
	public static String[] createStrArray2() {
		
		String tmp = Request.getParameter("msg_param_num");

		// 외부 입력값을 정수형으로 사용할 때 입력값의 크기를 검증하지 않고 사용
		int param_ct = Integer.parseInt(tmp);
		if (param_ct <= 0 || param_ct > 2028) {
			throw new IllegalArgumentException("The msg_param_num has invalid (" + tmp + ")");
		}
		return new String[param_ct];
	}

	public static void main(String[] args) {
		
		String[] s1 = createStrArray1();
		String[] s2 = createStrArray2();
	}
}

