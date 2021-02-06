<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%!Connection con;
	Statement st;
	ResultSet rs;
	int no = 0;
	String q , name1, pwd1; %>
	<%
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/onlinestore";
	con = DriverManager.getConnection(url, "root", "root");
	st = con.createStatement();

	name1 = request.getParameter("nametxt");
	pwd1 = request.getParameter("passtxt");
	st = con.createStatement();
	rs = st.executeQuery("select * from user where name='"+name1+"' and pass='"+pwd1+"'");
	%>
	<%
	if(rs.next()) {
	%>
	<h3>Login Succesful</h3>
	
	<%
	}
	else {
		%>
		<h3>unsuccesful</h3>	
		<%
	}
	
	%>
</body>
</html>