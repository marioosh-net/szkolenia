package myself.jndi;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Ping
 */
@WebServlet("/Ping")
public class Ping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:jboss/datasources/postgres")
	private DataSource postgres;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.getWriter().write("<html><body>");
		try {
			InitialContext ctx = new InitialContext();
			DataSource p = (DataSource) ctx.lookup("java:jboss/datasources/postgres");
			System.out.println(p.getClass().getName());
			Connection c = p.getConnection();
			ResultSet rs = c.prepareStatement("select * from version_test").executeQuery();

		    ResultSetMetaData rsmd = rs.getMetaData();
		    int numColumns = rsmd.getColumnCount();
		    
			while(rs.next()) {
				res.getWriter().write(rs.getString(1)+",");
				res.getWriter().write(rs.getString(2)+",");
				res.getWriter().write(rs.getString(3)+"<br/>");
				
			    for (int i=1; i<numColumns+1; i++) {
			    	res.getWriter().write(rs.getString(rsmd.getColumnName(i)));
			    }
				
			}
			rs.next();
			System.out.println("#" + rs.getInt(1));
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		res.getWriter().write("ok");
		res.getWriter().write("</body></html>");
	}
}
