package cluster.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/*")
public class ClusterTestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String test = (String)req.getSession().getAttribute("test");
		System.out.println(test);
		res.getWriter().write("test="+test+"\n");
		res.getWriter().write("JSESSIONID="+req.getSession().getId());
		if(test == null) {
			req.getSession().setAttribute("test", ""+System.currentTimeMillis());
		}
	}
}
