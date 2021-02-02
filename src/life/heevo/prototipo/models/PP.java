package life.heevo.prototipo.models;

/**
 * Representa um Profissional Prescritor
 * 
 * @author rk
 *
 */
public class PP {
	
	private String nome;
	private int cpf;
	private int codRegPro;
	
	public PP(String nome, int cpf, int codRegPro) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.codRegPro = codRegPro;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
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
