package cluster.listeners;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ClusterTestSessionListener
 *
 */
@WebListener
public class ClusterTestSessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent arg0) {
    	System.out.println("sessionCreated");
    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
    	System.out.println("sessionDestroyed");
    }
	
}
