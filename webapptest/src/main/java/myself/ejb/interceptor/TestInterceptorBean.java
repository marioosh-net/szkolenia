package myself.ejb.interceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class TestInterceptorBean {
	
	@Interceptors(Interceptor.class)
	public void check(String p) {
		System.out.println("check");
	}
	
}
