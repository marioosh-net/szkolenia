package myself.ejb;

import javax.ejb.Stateless;

@Stateless
public class Hello implements HelloLocal, HelloRemote {

	@Override
	public String hello() {
		return "Hello World!";
	}

}
