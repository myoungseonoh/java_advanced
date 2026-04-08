package securecoding.error;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

class Response {
	
	static void sendErrmsg(String msg) {
		System.out.println("send ... ");
		System.out.println(" >> " + msg);
	}
}
 
class MyLogger {
	
	static void info(String msg) {
		System.out.println(" log : [" + LocalDate.now() + "] " + msg );
	}
}

public class HandleException {

	// 패턴1. 예외 삼키기
	public void writeData1(String filePath, String data) {
	
		FileWriter w;
		try {
			w = new FileWriter(filePath);
			w.write(data);
		} catch (IOException e) {
			//  skip.. .
			// 파일 저장에 실패했음에도 인지할 수 없음.
		} 
	}
	

	// 패턴2. 스태트레이스 노출 (보안취약)
	public void writeData2(String filePath, String data) {
	
		FileWriter w;
		try {
			w = new FileWriter(filePath);
			w.write(data);
		} catch (IOException e) {
			// 파일 경로 노출됨
			Response.sendErrmsg("Error: " + e.getMessage()); 
		}
	}
	
	// 패턴3. 과도하게 넓은 캐치
	public void writeData3() {
		
		try {
			String filePath = "d:/a/b/c.dat"; 	// 파일 경로 구성... 
			String data = "test data...."; 		// 저장하고자 하는 데이터 구성.. 
			
			FileWriter w = new FileWriter(filePath);
			w.write(data);
		} catch (Exception e) {
			// 파일 경로 노출됨
			MyLogger.info("저장 실패"); 
		}
	}
	
	public static void main(String[] args) {
		
		HandleException e = new HandleException();
//		e.writeData2("D:/test/path/a.txt", "testdata");
		
		e.writeData3();
		
	}
}
