package test;


import java.io.IOException;
import java.sql.SQLException;

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
		//ejb.check1();
		try {
			ejb.check2();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ejb.check3();
		ejb.check4();
		res.getWriter().write("ok");
		
	}

}
