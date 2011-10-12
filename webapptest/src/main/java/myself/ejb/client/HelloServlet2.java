package myself.ejb.client;

import java.io.IOException;
import java.io.Writer;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myself.ejb.Hello;
import myself.ejb.HelloLocal;
import myself.ejb.HelloStateful;

/**
 * klient w postaci servletu wykorzystujacy ejb
 */
@WebServlet("/HelloServlet2")
public class HelloServlet2 extends HttpServlet implements Runnable {
	private static final long serialVersionUID = 1L;

	/**
	 * @EJB - wstrzykiwanie ejb
	 */
	@EJB
	private HelloStateful hello; 
	@EJB
	private HelloStateful hello2;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Writer out = res.getWriter();
		try {
			new Thread(this).start();
			new Thread(this).start();
			new Thread(this).start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I'm");
		System.out.println(""+hello.hello());
		System.out.println(""+hello2.hello());
		System.out.println("again");
		System.out.println(""+hello.hello());
		System.out.println(""+hello2.hello());
		System.out.println("goodbye");
		
	}

}
