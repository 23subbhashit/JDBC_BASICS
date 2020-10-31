import java.sql.*;

public class JDBS_Prepared_Statements {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sampledb" ;
		String user = "root";
		String password = "TIGER";
		
 		try {
 			//Connection to DB
			Connection myconn = DriverManager.getConnection(url,user,password);
			//Create a statement
			PreparedStatement myStmt = myconn.prepareStatement("select * from users where user_id>?");
			myStmt.setInt(1,4);
			ResultSet myRs = myStmt.executeQuery();
			while(myRs.next()) {
				System.out.println(myRs.getString("username")+" is a "+myRs.getString("user_id"));
			}
			
		}
		catch(Exception exc ){
			exc.printStackTrace();
		}
	}

}
