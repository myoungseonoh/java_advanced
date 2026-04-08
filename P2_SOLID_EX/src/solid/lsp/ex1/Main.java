package solid.lsp.ex1;

interface NaturalType {

    void print();
}

class Mammals implements NaturalType {
	
	final String type = "포유류";
	
	@Override
	public void print() {
		System.out.println("이 동물의 종류는 " + type + " 입니다.");
	}
}

class Animal {

	NaturalType n  = null;
	int footCnt = 0;
	
	Animal(NaturalType n, int cnt) {
		this.n = n;
		this.footCnt = cnt;
	}
	
	// 동물의 다리의 갯수를 확인한다.
	int getFootCnt() {
		return footCnt;
	}
	
	public void print() {
		n.print();
		System.out.println("이 동물의 다리는 " + getFootCnt() + "개 입니다.");
	}
}

class Dog extends Animal {
	
	public Dog() {
		super(new Mammals(), 4);
	}
}

class Cat extends Animal {
	
	public Cat() {
		super(new Mammals(), 4);
	}
	
	// 부모 클래스의 행동 규약을 준수하지 않음!
	@Override
	int getFootCnt() {
		return 0;
	}
	
	// 발이 아니라 손의 갯수로 변경해 버림
	int getHandCnt() {
		return footCnt;
	}
}

public class Main {

	public static void main(String[] args) {
		
		// 정상적인 실행
		Animal dog = new Dog();
		dog.print();
		
		// 예상하지 못한 실행
		Animal cat = new Cat();
		cat.print();
		
    }
}
