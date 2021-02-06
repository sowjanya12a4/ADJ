package servelets;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/onlinestore";
	static final String USER = "root";
	static final String PASS = "root";
	public Connection con;
	public void init(ServletConfig sc) throws ServletException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/onlinestore";
			con=DriverManager.getConnection(DB_URL,USER,PASS);
		}
		catch (Exception e)
		{
			System.out.println("Error in connection"+e.getMessage());
		}
	} 
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		PrintWriter pw = res.getWriter();

		Statement st;
		Statement s1;
		try {
			String name = req.getParameter("nametxt");
			String pass = req.getParameter("passtxt");
			String email = req.getParameter("emailtxt");
			String phno = req.getParameter("phtxt");
			st = con.createStatement();
			String qry="insert into user values(?,?,?,?)";
			PreparedStatement insertQuery=con.prepareStatement(qry); 
			insertQuery.setString(1,name);
			insertQuery.setString(2,pass);
			insertQuery.setString(3,email);
			insertQuery.setString(4,phno);
			int num = insertQuery.executeUpdate();
			pw.println("<html>");
			pw.println("<body>" + "<h1>" + num + " row is updated</h1>");
			s1 = con.createStatement();
			ResultSet rs = s1.executeQuery("select * from user");
			pw.println("<table width=0>");
			pw.println("<tr><th>Register number </th>");
			pw.println("<th>password</th> <th>email-id</th>");
			pw.println("<th>ph_no</th></tr>");
			while (rs.next())
			{
				pw.println("<tr><td>" + rs.getString(1) + "</td><td>");
				pw.println(rs.getString(2) + "</td><td>");
				pw.println(rs.getString(3)+ "</td><td>");
				pw.println(rs.getString(4) + "</td></tr>");
			}
			pw.println("</table></body></html>");
			pw.close();
		}
		catch (SQLException e)
		{
			pw.println(e); 
		}
		catch (Exception e)
		{
			pw.println(e);
		}
	}
}