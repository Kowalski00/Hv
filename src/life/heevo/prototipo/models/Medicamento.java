package life.heevo.prototipo.models;

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
	public String getTipo() {
		return tipo;
	}
	public String getDosagem() {
		return dosagem;
	}
	public String getFrequencia() {
		return frequencia;
	}
	public int getQtde() {
		return qtde;
	}
	
}
