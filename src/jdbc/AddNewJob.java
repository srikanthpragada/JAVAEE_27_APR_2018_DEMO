package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewJob {
	public static void main(String[] args) {
		try (Connection con = 
				DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			PreparedStatement ps = con.prepareStatement
					("insert into jobs(job_id,job_title) values(?,?)");
			ps.setString(1, "PY_PROG");
			ps.setString(2, "Python Programmer");
//			ps.setInt(3, 5000);
//			ps.setInt(4, 10000);
			
			ps.executeUpdate();  // INSERT
			
			System.out.println("Added Job Successfully!");
			
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}

	}

}
