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
	private Long cpf;
	private int codRegPro;
	private static ArrayList<Long> listaProntuario = new ArrayList<Long>();
	
	public PP(String nome, Long cpf, int codRegPro) {
		this.nome = nome;
		this.cpf = cpf;
		this.codRegPro = codRegPro;
	}

	public void addProntuario(Long UniqueID){
		listaProntuario.add(UniqueID);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public int getCodRegPro() {
		return codRegPro;
	}

	public void setCodRegPro(int codRegPro) {
		this.codRegPro = codRegPro;
	}

	@Override
	public String toString() {
		return "Profissional Prescritor: " + nome + ", CPF:" + cpf + ", CRP:" + codRegPro;
	}
	
	
}
