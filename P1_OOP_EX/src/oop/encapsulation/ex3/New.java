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
		
        User1 userRm = new User1("RM", 30, "rm@naver.com", "010-1234-7896");
        User1 userV = new User1("V", 30, "v@naver.com", "010-8521-5678");

        System.out.println(userRm);
        System.out.println(userV);
    }

}
