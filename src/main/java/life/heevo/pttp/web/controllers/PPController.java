package life.heevo.pttp.web.controllers;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import life.heevo.pttp.web.entities.PP;
import life.heevo.pttp.web.services.PPService;

public class PPController extends ActionSupport {

	private static final long serialVersionUID = 4980053945238341811L;

	private PP pp;
	private List<PP> pps;
	private String msgnErro;
	private List<PP> ppsPorNome;

	public String inserirPP() {
		try {
			PPService ppServ = new PPService();
			ppServ.inserirPP(this.pp);
			return SUCCESS;
		} catch (Exception e) {
			this.msgnErro = e.getMessage();
			return ERROR;
		}
	}

	public String listarPPs() {
		try {
			PPService ppServ = new PPService();
			this.pps = ppServ.listarTodosPPs();
			return SUCCESS;
		} catch (Exception e) {
			this.msgnErro = e.getMessage();
			return ERROR;
		}
	}
	public String pesquisarPpPorNome() {
		PPService ppServ = new PPService();
		String nome = ActionContext.getContext().getParameters().get("nome").getValue();
		this.ppsPorNome = ppServ.pesquisarPorNomePP(nome);
		return SUCCESS;
	}
	public String pesquisarPpPorCpf() {
		PPService ppServ = new PPService();
		String cpf = ActionContext.getContext().getParameters().get("cpf").getValue();
		this.pp = ppServ.pesquisarPpPorCpf(cpf);
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (this.pp != null) {
			if (this.pp.getNome().isEmpty()) {
				addFieldError("pp.nome", "Por favor, insira o Nome");
			}
			if (this.pp.getNome().length() < 3) {
				addFieldError("pp.nome", "O nome deve conter no mínimo 3 caracteres");
			}
			if (this.pp.getCpf().isEmpty()) {
				addFieldError("pp.cpf", "Por favor, insira o CPF");
			}
			if (this.pp.getCpf().length()!=11) {
				addFieldError("pp.cpf", "O CPF deve conter 11 caracteres");
			}
		}
	}

	public PP getPp() {
		return pp;
	}

	public void setPp(PP pp) {
		this.pp = pp;
	}

	public List<PP> getPps() {
		return pps;
	}

	public void setPps(List<PP> pps) {
		this.pps = pps;
	}

	public String getMsgnErro() {
		return msgnErro;
	}

	public List<PP> getPpsPorNome() {
		return ppsPorNome;
	}
}
