package myself.jndi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClTest")
public class ClTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			System.out.println(this.getClass().getClassLoader().getClass().getName());
			System.out.println(HttpServlet.class.getClassLoader().getClass().getName());
			System.out.println(Thread.currentThread().getContextClassLoader().getClass().getName());

			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			while (cl != null) {
				System.out.println(cl.getClass().getName());
				cl = cl.getParent();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
