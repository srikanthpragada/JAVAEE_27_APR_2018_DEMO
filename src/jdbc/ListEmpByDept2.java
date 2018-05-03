package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ListEmpByDept2 {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			PreparedStatement ps = con.prepareStatement
					("select * from employees where department_id = ?");
			
			Scanner s  = new Scanner(System.in);
			System.out.print("Enter dept id : ");
			String deptid = s.nextLine();
			
			ps.setString(1, deptid);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.printf("%-15s - %d\n",
						 rs.getString("first_name"), rs.getInt("salary"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
