package life.heevo.pttp.web.actions;

import com.opensymphony.xwork2.ActionSupport;

import life.heevo.pttp.web.entities.PP;
import life.heevo.pttp.web.services.PPService;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = -4389433796134935682L;
	
	private String cpf; 
	private PP pp;
	private String msgnErro;

	public String logarPP() {
		PP pp = new PP();
		PPService ppServ = new PPService();
		pp = ppServ.pesquisarPpPorCpf(this.pp.getCpf());
		if(pp!=null)
			return SUCCESS;
		else {
			this.msgnErro = "CPF inexistente";
			return ERROR;
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

}
