package myself.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean	// bez tego domyslnie wystawiany jest no-interface view
@Stateless	// (name="hello") mozna podac name, inaczej przyjmuje nazwe klasy (Hello)
public class Hello implements HelloLocal, HelloRemote {

	public static int count;
	
	@Override
	public String hello() {
		return "Hello World!";
	}

	@PostConstruct
	private void create() {
		System.out.println("post contruct: "+ ++count);
	}
}
