package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSalary {

	public static void main(String[] args) {
     
		try(Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"))
		{
			 Statement st = con.createStatement();
			 int count = st.executeUpdate
			 ("update employees set salary = salary * 1.1 where employee_id = 111");
			 
			 if ( count == 1 )
				 System.out.println("Updated Successfully!");
			 else
				 System.out.println("Employee Id Not Found!");
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
