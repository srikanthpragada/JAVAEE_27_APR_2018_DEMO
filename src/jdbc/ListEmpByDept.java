package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ListEmpByDept {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			Statement st = con.createStatement();
			Scanner s  = new Scanner(System.in);
			System.out.print("Enter dept id : ");
			String deptid = s.nextLine();
			ResultSet rs = st.executeQuery
					("select * from employees where department_id = " + deptid);
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
