package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginClass
 */
public class LoginClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Enumeration en;
	 ServletConfig sc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClass() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig sc) throws ServletException
    {
    this.sc = sc;
    en = sc.getInitParameterNames();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie c[] = new Cookie[4];
		 int i = 0;
		 while (en.hasMoreElements())
		 {
		 String name = (String) en.nextElement();
		 String value = sc.getInitParameter(name);
		 System.out.println(name);
		 c[i] = new Cookie(name, value);
		 res.addCookie(c[i]);
		 i++;
		 }
		 PrintWriter pw = res.getWriter();
		 pw.println("<head>");
		 pw.println("<head><title>Welcome to loginpage");
		 pw.println("</title></head>");
		 pw.println("<body>" + "<form action=./LoginClass method=post>");
		pw.println("<br><br><br><center>");
		pw.println("<font size=4>Login:</font>");
		pw.println("<input type=text name=t1> <br><br>");
		pw.println("<font size=4>Password:</font>");
		pw.println("<input type=password name=t2> <br>");
		pw.println("<input type=submit value=Submit>");
		pw.println("<input type=reset value=Reset> </center>");
		 pw.println("</form></body></html>");
		 pw.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = res.getWriter(); 
		 String name = req.getParameter("t1");
		 String pass = req.getParameter("t2");
		 Cookie c[] = req.getCookies();
		 int flag = 0;
		 for (Cookie x : c)
		 {
		 String cname = (String) x.getName();
		 String cpass = (String) x.getValue();
		 if (name.equals(cname) && pass.equals(cpass))
		 {
		 pw.println("<h1>Welcome " + name + "</h1>");
		 flag = 1;
		 break;
		 }
		 }
		 if (flag == 0)
		 {
		 pw.println("<h1> You are not authenticated user</h1>");
		 }
		 pw.close();
	}

}
