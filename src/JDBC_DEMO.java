import java.sql.*;

public class JDBC_DEMO {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sampledb" ;
		String user = "root";
		String password = "TIGER";
 		try {
 			//Connection to DB
			Connection myconn = DriverManager.getConnection(url,user,password);
			//Create a statement
			Statement myStmt = myconn.createStatement();
			//Select query
			ResultSet myRs = myStmt.executeQuery("select * from users");
			while(myRs.next()) {
				System.out.println(myRs.getString("username"));
			}
			//Insert query
			String sql = "insert into users"
					+ "(user_id,username,password,fullname,email)"
					+ "values(10,'Jaddu','88090','aryan','aryan@microsoft.mars')";
			myStmt.executeUpdate(sql);
			System.out.println("Inserted");
			
		}
		catch(Exception exc ){
			exc.printStackTrace();
		}
	}

}
