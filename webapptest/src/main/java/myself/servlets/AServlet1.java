package myself.servlets;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/a1", asyncSupported=true)
public class AServlet1 extends HttpServlet {
	
	static AsyncContext ctx;
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		AsyncContext ctx = arg0.startAsync();
		System.out.println("Async started");
		AServlet1.ctx = ctx;
	}
}
