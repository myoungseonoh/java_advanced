package oop.encapsulation.ex3;

class User3 {
	private String name;
	private int age;
	private String email;
	private String phone;

	// -----------------------
	// 다양한 생성 옵션
	User3(String name, int age, String email, String phone) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	
	User3(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	User3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	// -----------------------
	
	private User3(Builder user) {
		this.name = user.name;
	    this.age = 	user.age;
	    this.email = user.email;
	    this.phone = user.phone;
	}
	
	public static class Builder {
		
	    private String name;
	    private int age;
	    private String email;
	    private String phone;
	
	    public Builder name(String name) {
	      this.name = name;
	      return this;
	    }
	
	    public Builder age(int age) {
	      this.age = age;
	      return this;
	    }
	
	    public Builder email(String email) {
	      this.email = email;
	      return this;
	    }
	
	    public Builder phone(String phone) {
	      this.phone = phone;
	      return this;
	    }
	
	    public User3 build() {
	      return new User3(this);
	    }
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + "]";
	}
}

public class Builder {

	public static void main(String[] args) throws Exception {
        User3 user = new User3.Builder()
                .name("Chrisbaba")
                .age(30)
                .email("chrisbaba@naver.com")
                .phone("010-1234-5678")
                .build();
    }
}
