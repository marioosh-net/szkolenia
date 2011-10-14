package test;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JPATestServlet
 */
@WebServlet("/*")
public class JPATestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private TestEJB ejb;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ejb.check1();
		res.getWriter().write("ok");
		
	}

}
