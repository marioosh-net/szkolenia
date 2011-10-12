package myself.ejb;

import javax.ejb.Remote;

/**
 * interfejs zewnetrzny
 */
@Remote
public interface HelloRemote {
	public String hello();
}
