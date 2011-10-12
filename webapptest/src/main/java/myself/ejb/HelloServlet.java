package myself.ejb;

import java.io.IOException;
import java.io.Writer;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * klient w postaci servletu wykorzystujacy ejb
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Writer out = res.getWriter();
		try {
			InitialContext ctx = new InitialContext();
			HelloLocal ejb = (HelloLocal) ctx.lookup("java:global/webapptest/Hello!myself.ejb.HelloLocal");

			out.write(ejb.hello());
			out.write("\n"+ejb.getClass().getName());

		} catch (Exception e) {

		}
	}

}
