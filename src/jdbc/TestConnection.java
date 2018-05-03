package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			System.out.println(con.getClass());
			
			System.out.println("Connected To Oracle");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
