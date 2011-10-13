package myself.jms;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.ejb.ActivationConfigProperty;
/*

@MessageDriven (activationConfig={
		@ActivationConfigProperty(propertyName="destination",propertyValue="java:/queue/test"),
		@ActivationConfigProperty(propertyName="destinationType",propertyValue="queue/test")
})
*/

public class JmsReceiver { /* implements MessageListener {

	/*
	@Override
	public void onMessage(Message msg) {
		System.out.println(msg);
	}
	*/

}
