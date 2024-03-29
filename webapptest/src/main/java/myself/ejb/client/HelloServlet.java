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

/**
 * klient w postaci servletu wykorzystujacy ejb
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet implements Runnable {
	private static final long serialVersionUID = 1L;

	/**
	 * @EJB - wstrzykiwanie ejb
	 */
	@EJB
	private Hello hello; 
	@EJB
	private Hello hello2;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Writer out = res.getWriter();
		try {
			InitialContext ctx = new InitialContext();
			HelloLocal ejb = (HelloLocal) ctx.lookup("java:global/webapptest/Hello!myself.ejb.HelloLocal");

			out.write(ejb.hello());
			out.write("\n"+ejb.getClass().getName());
			
			Hello ejb2 = (Hello) ctx.lookup("java:global/webapptest/Hello!myself.ejb.Hello");
			out.write(ejb2.hello());
			out.write("\n"+ejb2.getClass().getName());			
			
			// po wstrzyknieciu mamy dostep od razu, nie trzeba lookup'owac
			/**
			 * wsztrzykujemy dwa beany, ale tak naprawde tworzony jest jeden
			 * wykorzystywany i wrzucany do "basenu", potem pobierany jest ten sam
			 */
			System.out.println("I'm");
			System.out.println(""+hello.hello());
			System.out.println(""+hello2.hello());
			System.out.println("again");
			System.out.println(""+hello.hello());
			System.out.println(""+hello2.hello());
			System.out.println("goodbye");
			
			new Thread(this).start();
			new Thread(this).start();
			new Thread(this).start();
			new Thread(this).start();
			new Thread(this).start();
			new Thread(this).start();
			new Thread(this).start();
			new Thread(this).start();
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
