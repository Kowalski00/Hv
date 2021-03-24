package life.heevo.pttp.web.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import life.heevo.pttp.web.entities.PP;
import life.heevo.pttp.web.services.PPService;

public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -4389433796134935682L;
	
	private String cpf; 
	private PP pp;
	private String msgnErro;
	private Map<String,Object> session;

	@Override
	public String execute() {
		clearFieldErrors();
		PP pp = (PP) session.get("pp");
		if(pp!=null) {
			return SUCCESS;
		}
		else {
			PP ppNew = null;
			if(this.pp !=null) {
				ppNew = isValid(this.pp.getCpf());
			}
			if(ppNew != null) {
				session.put("pp", ppNew);
				return SUCCESS;
			}
			
		}
		this.msgnErro = "Inválido";
		return INPUT;
	}
	
	private PP isValid(String cpf) {
		PP ppExistente = new PP();
		PPService ppServ = new PPService();
		try {
			ppExistente = ppServ.pesquisarPpPorCpf(cpf);
			if(ppExistente!=null)
				return ppExistente;
			else
				return null;
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public void validate() {
		if(this.pp != null) {
			if(this.pp.getCpf().isEmpty())
				addFieldError("pp.cpf", "Por favor informe o CPF");
		}
	}


	public String getCpf() {
		return cpf;
	}
	

	public PP getPp() {
		return pp;
	}


	public void setPp(PP pp) {
		this.pp = pp;
	}


	public String getMsgnErro() {
		return msgnErro;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

}
