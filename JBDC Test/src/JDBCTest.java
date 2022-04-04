import java.sql.*;

public class JDBCTest {
	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			//Telling JDBC to use MYSQL Driver
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
			
			
			
			//Create, Alter, Drop, - table - in sql -ddl- Data Definition Language
			//Select, update, delete, insert - rows - in sql - dml - Data Manipulation Language
			
			//Select Statement
			Statement statement = connection.createStatement();
			
			int rowsAffected = statement.executeUpdate( "insert into employees" +
			"(last_name, first_name, email, department, salary)" +
			"values" + 
			"('Wright', 'Eric', 'eric,wright@foo.com' 'HR', 33000.00)");
			
			
			//Create a String with query in it 
			String query = "Select * from employees order by last_name";
			
			ResultSet myRs = statement.executeQuery(query);
			
			while(myRs.next()) {
				
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name") + " ");
				
			}
		}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		
			
		
	}

}
