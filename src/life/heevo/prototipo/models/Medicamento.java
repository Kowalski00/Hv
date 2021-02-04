package life.heevo.prototipo.models;

public class Medicamento {
	private String medicamento;
	private String tipo;
	private String dosagem;
	private String frequencia;
	
	public Medicamento(String nome, String tipo, String dosagem, String frequencia) {
		this.medicamento = nome;
		this.tipo = tipo;
		this.dosagem = dosagem;
		this.frequencia = frequencia;
	}
	
}
