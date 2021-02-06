<html>
<body>
	<%@ page import="java.sql.*"%>
	<%!Connection con;
	Statement st;
	ResultSet rs;
	int no;
	String q, name1, pwd1, email1, phoneno;%>
	<%
		Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/onlinestore";
	con = DriverManager.getConnection(url, "root", "root");
	st = con.createStatement();

	name1 = request.getParameter("nametxt");
	pwd1 = request.getParameter("passtxt");
	email1 = request.getParameter("emailtxt");
	phoneno = request.getParameter("phtxt");
	q = "insert into user values ('" + name1 + "','" + pwd1 + "','" + email1;
	q = q + "','" + phoneno + "')";
	no = st.executeUpdate(q);
	if (no > 0) {
	%>

	<h3><%=no%>
		row is inserted
	</h3>
	<%
		}
	%>
	<h3>Total Users</h3>
	<table width=0>
		<tr>
			<th>Register number</th>
			<th>password</th>
			<th>email-id</th>
			<th>ph_no</th>
		</tr>
		<%
			st = con.createStatement();
		rs = st.executeQuery("select * from user");
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString(1)%>
			<td><%=rs.getString(2)%>
			<td><%=rs.getString(3)%>
			<td><%=rs.getString(4)%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>