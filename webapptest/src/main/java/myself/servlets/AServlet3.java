package myself.servlets;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/a3", asyncSupported=false)
public class AServlet3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		AsyncContext ctx = AServlet1.ctx;
		ctx.getResponse().getWriter().write("parted");
		ctx.complete();
		System.out.println("Complete");
	}
}
