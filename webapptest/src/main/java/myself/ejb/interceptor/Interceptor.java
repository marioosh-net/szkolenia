package myself.ejb.interceptor;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Interceptor {
	
	@AroundInvoke
	public Object invoke(InvocationContext ctx) {
		System.out.println("invoked: "+ctx.getTarget().getClass().getName()+
				", "+ctx.getMethod().getName()+ " ("+Arrays.toString(ctx.getParameters())+")");
		return null;
	}
	
	@PostConstruct
	private void create(InvocationContext ctx) {
		System.out.println("Interceptor created");
		try {
			ctx.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
