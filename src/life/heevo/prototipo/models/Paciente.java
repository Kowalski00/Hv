package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa um Paciente
 * 
 * @author rk
 *
 */
public class Paciente {

	private int cpf;
	private String Nome;
	private String dataCriado;
	
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public Paciente(int cpf, String nome) {
		super();
		this.cpf = cpf;
		Nome = nome;
		this.dataCriado = formatter.format(date);
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDataCriado() {
		return dataCriado;
	}
	public void setDataCriado(String dataCriado) {
		this.dataCriado = dataCriado;
	}
	@Override
	public String toString() {
		return "Paciente: CPF=" + cpf + ", Nome=" + Nome;
	}
	
	
	
}
