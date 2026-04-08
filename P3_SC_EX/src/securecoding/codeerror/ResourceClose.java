package securecoding.codeerror;

class MyResource implements AutoCloseable {

    @Override
    public void close() throws RuntimeException{
        System.out.println("close");
        throw new IllegalStateException();
    }

    public void hello() {
        System.out.println("hello");
        throw new IllegalStateException();
    }
}

class MyResource2 implements AutoCloseable {

    @Override
    public void close() throws RuntimeException{
        System.out.println("close");
        throw new IllegalStateException();
    }

    public void hello() {
        System.out.println("hello");
    }
}
	
public class ResourceClose {

	public static void missTrace1() {
		
		MyResource mangKyuResource = null;

	    try {
	        mangKyuResource = new MyResource();
	        mangKyuResource.hello(); // Hello 오류는 누락됨
	    } finally {
	        if (mangKyuResource != null) {
	            mangKyuResource.close();
	        }
	    }
	
	}
	
	public static void missTrace2() {
	    try (MyResource mangKyuResource = new MyResource()) {
	        mangKyuResource.hello();
	    }
	}

	public static void missClose1() {
		MyResource2 resource1 = null;
		MyResource2 resource2 = null;

		try {
			resource1 = new MyResource2();
			resource2 = new MyResource2();
			resource1.hello();
			resource2.hello();
		} finally {
			if (resource1 != null) {
				resource1.close();
			}

			if (resource2 != null) { // Miss!
				resource2.close();
			}
		}
	}

	public static void missClose2() {
	    try (MyResource2 resource1 = new MyResource2(); 
	    	MyResource2 resource2 = new MyResource2()) {
	        resource1.hello();
	        resource2.hello();
	    }
	}
	
	public static void main(String[] args) {
		
		// (Case1) StackTrace 누락
//		ResourceClose.missTrace1();
//		ResourceClose.missTrace2();
				
		// (Case2) 
//		ResourceClose.missClose1();
		ResourceClose.missClose2();
	}
	
//	
//	public void close1() {
//		
//		// 전통적인 방식 - finally 빼먹으면 자원 누수
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//		    conn = getConnection();
//		    pstmt = conn.prepareStatement(sql);
//		    // ... 작업
//		} finally {
//		    if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
//		    if (conn != null) try { conn.close(); } catch (SQLException e) {}
//		}
//	}
//	
//	public void close2() {
//		
//		// try-with-resources - 자원 해제 보장 + 코드 단순화 (Java 7+)
//		try (Connection conn = getConnection();
//		     PreparedStatement pstmt = conn.prepareStatement(sql)) {
//		    // ... 작업
//		} // conn, pstmt 자동 close() 보장
//
//	}
}
