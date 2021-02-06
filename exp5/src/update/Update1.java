package update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Update1 {

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
			

			
			String query="update employee1 set age=? where id=?";
			
			PreparedStatement upsmt=con.prepareStatement(query);
			
			upsmt.setInt(1,18);// age=1 id=2 first element in set;
			upsmt.setInt(2,1);
			upsmt.setInt(1, 20);
			upsmt.setInt(2, 2);
			int rows=upsmt.executeUpdate();
			// retrieve the data from resultset
			System.out.println(rows+" row(s) are updated.");
			
			
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from employee1");
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