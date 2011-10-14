package cluster.listeners;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class ClusterTestSessionAttributeListener
 *
 */
@WebListener
public class ClusterTestSessionAttributeListener implements HttpSessionAttributeListener {

    public void attributeRemoved(HttpSessionBindingEvent arg0) {
    	System.out.println("attributeRemoved: " + arg0.getName());
    }

    public void attributeAdded(HttpSessionBindingEvent arg0) {
    	System.out.println("attributeAdded: " + arg0.getName());
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0) {
    	System.out.println("attributeReplaced: " + arg0.getName());
    }
	
}
