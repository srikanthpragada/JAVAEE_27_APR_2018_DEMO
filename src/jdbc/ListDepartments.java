package jdbc;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class ListDepartments {

	public static void main(String[] args) throws Exception {
		CachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from departments where department_id < ?");
		crs.setInt(1, 50);
		crs.execute();  // Connect and retrieve data 
		while(crs.next()) {
			System.out.println(crs.getString("department_name"));
		}
		crs.close();
	}

}
