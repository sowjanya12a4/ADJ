package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/shopservlet")
public class shopservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String book1cost = request.getParameter("book1cost");
		String book2cost = request.getParameter("book2cost");
		String book3cost = request.getParameter("book3cost");
		String book4cost = request.getParameter("book4cost");
		
		String book1 = request.getParameter("book1");
		String book2 = request.getParameter("book2");
		String book3 = request.getParameter("book3");
		String book4 = request.getParameter("book4");
		
		int book1amt = 0, book2amt = 0, book3amt = 0, book4amt = 0;
		
		HttpSession session = request.getSession(true);
		
		if(book1 != null && !book1.equals("")) {
			book1amt = Integer.parseInt(book1cost) * Integer.parseInt(book1);
			if(session.getAttribute("book1amt") != null) {
				book1amt = book1amt + Integer.parseInt(session.getAttribute("book1amt").toString());
			}
			
			session.setAttribute("book1amt", book1amt+"");
		}
		if(book2 != null && !book2.equals("")) {
			book2amt = Integer.parseInt(book2cost) * Integer.parseInt(book2);
			if(session.getAttribute("book2amt") != null) {
				book2amt = book2amt + Integer.parseInt(session.getAttribute("book2amt").toString());
			}
			session.setAttribute("book2amt", book2amt+"");
		}
		if(book3 != null && !book3.equals("")) {
			book3amt = Integer.parseInt(book3cost) * Integer.parseInt(book3);
			if(session.getAttribute("book3amt") != null) {
				book3amt = book3amt + Integer.parseInt(session.getAttribute("book3amt").toString());
			}
			session.setAttribute("book3amt", book3amt+"");
		}
		if(book4 != null && !book4.equals("")) {
			book4amt = Integer.parseInt(book4cost) * Integer.parseInt(book4);
			if(session.getAttribute("book4amt") != null) {
				book4amt = book4amt + Integer.parseInt(session.getAttribute("book4amt").toString());
			}
			session.setAttribute("book4amt", book4amt+"");
		}	
		
		response.sendRedirect("./Book.html");
		
	}
		

}
