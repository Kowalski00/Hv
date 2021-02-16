package life.heevo.prototipo.models;

/**
 * Representa um Medicamento
 * 
 * @author hl
 * @author rk
 *
 */
public class Medicamento {
	private String medicamento;
	private String tipo;
	private String dosagem;
	private String frequencia;
	private int qtde;
	
	public Medicamento(String nome, String tipo, String dosagem, String frequencia, int qtde) {
		this.medicamento = nome;
		this.tipo = tipo;
		this.dosagem = dosagem;
		this.frequencia = frequencia;
		this.qtde = qtde;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	@Override
	public String toString() {
		return "Medicamento ( "+medicamento + ", " + tipo + "\n Dosagem: " + dosagem + ", Frequencia: "
				+ frequencia + ", Quanntidade:" + qtde + ")";
	}
	
	
}
