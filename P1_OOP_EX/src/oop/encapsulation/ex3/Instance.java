package oop.encapsulation.ex3;

abstract class School {

	abstract String getName();
	abstract String getLocation();
	
	public static School getInstance(String type, String name, String location) {
		return switch (type.toLowerCase()) {
			case "high" -> new HighSchool(name, location);
			case "middle" -> new MiddleSchool(name, location);
			default -> throw new IllegalArgumentException(
                    "지원하지 않는 기기 타입: " + type);
		};
	}
}

class HighSchool extends School {
	
	String name;
	String location;
	
	HighSchool(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	public 	String getLocation() {
		return location;
	}
}

class MiddleSchool extends School {
	
	String name;
	String location;
	
	MiddleSchool(String name, String location) {
		this.name = name;
		this.location = location;
	}
		
	public String getName() {
		return name;
	}
	public 	String getLocation() {
		return location;
	}
}

class User20 {
	
	String name;
	int age;
	String email;
	String phone;
	
	User20(String name, int age, String email, String phone) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
}

class User2 extends User20 {
	
	private static User2 anonymous;
	
	// private: 외부에서 생성자 호출을 막음
	private User2(String name, int age, String email, String phone) {
		// 검증 로직 사용 불가
//		if (age < 19) {
//			throw new IllegalArgumentException("The user is not adult.");
//		}
		super(name, age, email, phone);
	}
	
	// 검증로직 추가
	public static User2 getInstance(String name, int age, String email, String phone) {
		if (age < 19) {
			throw new IllegalArgumentException("The user is not adult.");
		}
		return new User2(name, age, email, phone);		
	}
	
	// single tone
	public static User2 getInstance() {
		if (anonymous == null) {
			anonymous = new User2("none", 0, "a@b.c", "000-0000-0000");
		}
		return anonymous;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + "]";
	}
}

public class Instance {

	public static void main(String[] args) throws Exception {
		
        User2 user = User2.getInstance("Chrisbaba", 30, "chrisbaba@naver.com", "010-1234-5678");
        System.out.println(user);
        
        // singletone
        User2 user2 = User2.getInstance();

        // Abstract Class -> MiddleSchool, HigthScool 구현체 클래스 명 몰라도 됨	
        School school = School.getInstance("high", "poly", "Gwangmyeong");
        
        
    }
}
