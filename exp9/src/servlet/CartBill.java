package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartBill
 */
@WebServlet("/CartBill")
public class CartBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		
		int totamt = 0;
		Enumeration names = session.getAttributeNames();
		
		while(names.hasMoreElements()) {
			String name = names.nextElement().toString();
			String value = session.getAttribute(name).toString();
			totamt += Integer.parseInt(value);
		}
		
		String book1amt = "";
		String book2amt = "";
		String book3amt="";
		String book4amt = "";
		if(session.getAttribute("book1amt") != null) {
			book1amt = session.getAttribute("book1amt").toString();
		}
		if(session.getAttribute("book2amt") != null) {
			book2amt = session.getAttribute("book2amt").toString();
		}
		if(session.getAttribute("book3amt") != null) {
			book3amt = session.getAttribute("book3amt").toString();
		}
		if(session.getAttribute("book4amt") != null) {
			book4amt = session.getAttribute("book4amt").toString();
		}
		
		out.println("<table>");
		out.println("<tr><td>Pencil:</td><td>" + book1amt + "</td></tr>");
		out.println("<tr><td>Book:</td><td>" + book2amt + "</td></tr>");
		out.println("<tr><td>Laptop:</td><td>" + book3amt + "</td></tr>");
		out.println("<tr><td>Mobile:</td><td>" + book4amt + "</td></tr>");
		out.println("<tr><td>Total amount:</td><td>" + totamt + "</td></tr>");
		out.println("</table>");
		session.invalidate();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}
}
