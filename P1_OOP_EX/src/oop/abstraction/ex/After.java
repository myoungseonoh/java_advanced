package oop.abstraction.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// DB 접근 추상화
interface UserRepository {

	void regist(String username, String email, String age, String profilePath);
}

class MySqlUserRepository implements UserRepository {
	
	// 비지니스 로직은 그대로
	public void regist(String username, String email, String age, String profilePath) {
		
		String sql = "INSERT INTO users (username, email, age, profile_image) VALUES(?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db\r\n", "root", "1234");
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, username);
			pstmt.setString(2, email);
			pstmt.setString(3, age);
			pstmt.setString(4, profilePath);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class OracleUserRepository implements UserRepository {
	
	public void regist(String username, String email, String age, String profilePath) {
		
		String sql = "INSERT INTO users (username, email, age, profile_image) VALUES(?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection("jdbc:oracle://localhost:1521/test_db\r\n", "root", "1234");
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, username);
			pstmt.setString(2, email);
			pstmt.setString(3, age);
			pstmt.setString(4, profilePath);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

public class After {
	
	public void registerUser(String username, String email, String age, String profilePath) {

		// DB 변경 시 Repository 구현 클래스만 수정
		//UserRepository repository = new MySqlUserRepository();
		UserRepository repository = new OracleUserRepository();
		
		repository.regist(username, email, age, profilePath);
	}
}
