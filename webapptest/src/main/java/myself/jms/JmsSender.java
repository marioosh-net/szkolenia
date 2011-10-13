package myself.jms;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JmsSender
 */
@WebServlet("/JmsSender")
public class JmsSender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:/ConnectionFactory")
	private javax.jms.QueueConnectionFactory qcf;
	@Resource(mappedName = "java:/queue/test")
	private Queue q;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			QueueConnection c = qcf.createQueueConnection();
			QueueSession s = c.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = s.createSender(q);
			TextMessage m = s.createTextMessage("hello");
			sender.send(m);
			// close na connection zamyka sesjê i sendera/receivera
			c.close();
			// zaleca siê róbiæ close
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
