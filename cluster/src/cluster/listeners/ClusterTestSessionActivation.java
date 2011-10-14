package cluster.listeners;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class ClusterTestSessionActivation
 *
 */
@WebListener
public class ClusterTestSessionActivation implements HttpSessionActivationListener {
    public void sessionDidActivate(HttpSessionEvent arg0) {
    	System.out.println("sessionDidActivate");
    }

    public void sessionWillPassivate(HttpSessionEvent arg0) {
    	System.out.println("sessionWillPassivate");
    }
	
}
