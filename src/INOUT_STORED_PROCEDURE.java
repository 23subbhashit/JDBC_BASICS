import java.sql.*;

public class INOUT_STORED_PROCEDURE {

	public static void main(String[] args) throws Exception {

		Connection myConn = null;
		CallableStatement myStmt = null;

		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo1", "root", "TIGER");

			String theDepartment = "Engineering";
			
			// Prepare the stored procedure call
			myStmt = myConn
					.prepareCall("{call greet_the_department(?)}");

			// Set the parameters
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1, theDepartment);

			// Call stored procedure
			System.out.println("Calling stored procedure.  greet_the_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");			
			
			// Get the value of the INOUT parameter
			String theResult = myStmt.getString(1);
			
			System.out.println("\nThe result = " + theResult);

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myConn, myStmt);
		}
	}

	private static void close(Connection myConn, Statement myStmt) throws SQLException {
		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

}