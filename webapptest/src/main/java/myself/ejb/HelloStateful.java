package myself.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateful
public class HelloStateful implements HelloLocal, HelloRemote {

	public static int count;
	
	@Override
	public String hello() {
		return "Hello World Stateful!";
	}

	@PostConstruct
	private void create() {
		System.out.println("Stateful post contruct: "+ ++count);
	}
}
