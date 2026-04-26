package oop.encapsulation.ex3;

class User1 {
	private String name;
	private int age;
	private String email;
	private String phone;

	public User1(String name, int age, String email, String phone) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + "]";
	}
}

public class New {

	public static void main(String[] args) throws Exception {
		
        User1 user = new User1("Chrisbaba", 30, "chrisbaba@naver.com", "010-1234-5678");
        
        // 출력: User [name=Chrisbaba, age=30, email=chrisbaba@naver.com, phone=010-1234-5678]
        System.out.println(user);
    }

}
