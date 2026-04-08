package solid.lsp.ex2;

class Animal {
    int speed = 10; // m/s

    // 주어진 시간(초) 동안 날아간 거리를 리턴한다.
    int go(int secs) {
        return speed * secs;
    }
}

class Eagle extends Animal {
	
	// 부모 클래스에서의 규약을 어기고 사용 방법을 변경 (X)
	// 오버로딩 보다는 새로운 메서드 명을 사용하자
    String go(long distance) {
        return distance + "만큼 날아서 갔습니다.";
    }
    
    // 메서드 명을 새롭게 정의 (O)
    String getFlightDiscription(int distance) {
         return distance + "만큼 날아서 갔습니다.";
    }
}

public class Main {
    public static void main(String[] args) {
    	
        Animal eagle = new Eagle();
        
        // 상위클래스에서의 규약 
        int distance = eagle.go(10);
    }
}