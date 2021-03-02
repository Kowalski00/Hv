package life.heevo.prototipo.models;

import java.util.ArrayList;

/**
 * Representa um Profissional Prescritor
 * 
 * @author hl
 * @author rk
 *
 */
public class PP {
	
	private String nome;
	private String cpf;
	private String codRegPro;
	private static ArrayList<Long> listaProntuario = new ArrayList<Long>();

	public void addProntuario(Long UniqueID){
		listaProntuario.add(UniqueID);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCodRegPro() {
		return codRegPro;
	}

	public void setCodRegPro(String codRegPro) {
		this.codRegPro = codRegPro;
	}

	@Override
	public String toString() {
		return "Profissional Prescritor: " + nome + ", CPF:" + cpf + ", CRP:" + codRegPro;
	}
	
	
}
