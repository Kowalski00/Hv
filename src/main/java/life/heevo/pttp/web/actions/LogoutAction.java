package life.heevo.pttp.web.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{


	private static final long serialVersionUID = 3344265379527055843L;
	
	private Map<String,Object> session;
	
	
	
	@Override
	public String execute() throws Exception {
		session.remove("pp");
		return SUCCESS;
	}



	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}
	
}
