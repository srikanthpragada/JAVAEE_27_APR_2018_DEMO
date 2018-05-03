package jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;

class CostlyEmployees implements Predicate {
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			if (rs.getInt("salary") > 10000)
				return true;
			else
				return false;
		} catch (Exception ex) {
              return false;
		}
	}

	@Override
	public boolean evaluate(Object arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}

class CheapEmployees implements Predicate {
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			if (rs.getInt("salary") < 3000)
				return true;
			else
				return false;
		} catch (Exception ex) {
              return false;
		}
	}

	@Override
	public boolean evaluate(Object arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}


public class FilterRowSetDemo {

	public static void main(String[] args) throws Exception {
		FilteredRowSet frs = new OracleFilteredRowSet();
		frs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		frs.setUsername("hr");
		frs.setPassword("hr");
		frs.setCommand("select * from employees ");
		frs.execute(); // Connect and retrieve data
		frs.setFilter( new CostlyEmployees());
		
		System.out.println("Costly Employees");
		while (frs.next()) {
			System.out.println(frs.getString("first_name")
					+ " - " + frs.getString("salary"));
		}
		
		frs.setFilter( new CheapEmployees());
		
		System.out.println("Cheap Employees");
		
		frs.beforeFirst();  // go back to before first row 
		
		while (frs.next()) {
			System.out.println(frs.getString("first_name")
					+ " - " + frs.getString("salary"));
		}
		
		frs.close();
	}

}
