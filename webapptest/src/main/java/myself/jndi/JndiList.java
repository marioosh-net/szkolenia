package myself.jndi;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JndiList
 */
@WebServlet("/JndiList")
public class JndiList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		Writer out = arg1.getWriter();
		try {
			
			out.write("<html><body>");
			Context ctx = new InitialContext();
			NamingEnumeration<Binding> i = ctx.listBindings(arg0.getParameter("ctx"));
			while(i.hasMore()) {
				Binding b = i.next();
				out.write(b.getName()+ "<br/>");
			}
			out.write("</body></html>");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			out.write(e.getExplanation());
		}
		
	}

}
