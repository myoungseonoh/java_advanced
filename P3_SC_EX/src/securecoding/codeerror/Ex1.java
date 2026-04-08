package securecoding.codeerror;

import java.util.Collection;
import java.util.Iterator;

public class Ex1 {

	public static int cardinality1(Object obj, final Collection col) {

		int count = 0;
		if (col == null) {
			return count;
		}
		
		Iterator it = col.iterator();
		while (it.hasNext()) {
			Object elt = it.next();
			// obj가 null이고 elt가 null이 아닐 경우, Null.equals 가 되어 널(Null) 포인터 역참조가 발생한다.
			if ((null == obj && null == elt) || obj.equals(elt)) {
				count++;
			}
		}
		return count;
	}

	public static int cardinality2(Object obj, final Collection col) {
		int count = 0;
		if (col == null) {
			return count;
		}
		Iterator it = col.iterator();
		while (it.hasNext()) {
			Object elt = it.next();
			// obj가 null이 아닌 경우에만 obj.equal를 실행한다.
			if ((null == obj && null == elt) || (null != obj && obj.equals(elt))) {
				count++;
			}
		}
		return count;
	}
	
	public static void getUrl1() {
		String url = reuqest.getParamter("url");
		//url 에 null이 들어오면 널(Null) 포인터 역참조가 발생한다.
		if (url.equals("")) {
			System.out.println("Empty URL");
		}
	}
	
	public static void getUrl2() {
		String url = reuqest.getParamter("url");
		//url 에 null이 들어오면 널(Null) 포인터 역참조가 발생한다.
		if (url == null || url.equals("")) {
			System.out.println("Empty URL");
		}
	}
	
}
