package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from jobs");
			while (rs.next()) {
				System.out.printf("%-12s - %s\n",
						 rs.getString("job_id"), rs.getString("job_title"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
