package myself.ejb;

import javax.ejb.Local;

/**
 * interfejs lokalny
 */
@Local
public interface HelloLocal {
	public String hello();
}
