package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class  Select {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// load the jdbc driver-4 into application for mysql.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the connection.
			// DriverManager.getConnection(connectionURL, username,password)
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
			// Statement object creation.
			
			Statement stmt= con.createStatement();
			
			// execution of sql statement. output is table which is represented as resultset in application.
			ResultSet rs=stmt.executeQuery("select * from employee1 where id=1");
			
			// retrieve the data from resultset
			System.out.println("id\tfirst\tlast\tage");
			
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			
			con.close();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
   		
		
    }
}