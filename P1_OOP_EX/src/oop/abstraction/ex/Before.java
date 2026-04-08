package oop.abstraction.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Before {
	
	public void registerUser(String username, String email, String age, String profilePath) {

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
