package life.heevo.pttp.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

import life.heevo.pttp.web.entities.PP;

public class AuthenticationInterceptor implements Interceptor{

	private static final long serialVersionUID = 2875232415182399122L;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		PP pp = (PP) session.get("pp");
		if(pp==null){
			return ActionSupport.LOGIN;
		}
		return invocation.invoke();
	}

}
