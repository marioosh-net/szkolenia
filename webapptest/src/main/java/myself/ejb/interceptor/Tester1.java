package myself.ejb.interceptor;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Test interceptor
 */
@WebServlet("/Tester1")
public class Tester1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private TestInterceptorBean ejb;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		ejb.check("ala ma kota");
		res.getWriter().write("ok");
	}

}
