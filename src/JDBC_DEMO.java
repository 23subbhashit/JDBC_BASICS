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
					+ "values(11,'Jaddu1','880901','aryan1','aryan1@microsoft.mars')";
			myStmt.executeUpdate(sql);
			System.out.println("Inserted");
			
		}
		catch(Exception exc ){
			exc.printStackTrace();
		}
	}

}
