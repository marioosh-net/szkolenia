package myself.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean	// bez tego domyslnie wystawiany jest no-interface view
@Stateless	// (name="hello") mozna podac name, inaczej przyjmuje nazwe klasy (Hello)
public class Hello implements HelloLocal, HelloRemote {

	@Override
	public String hello() {
		return "Hello World!";
	}

}
