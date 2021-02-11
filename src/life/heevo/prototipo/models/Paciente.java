package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Representa um Paciente
 * 
 * @author rk
 *
 */
public class Paciente {

	private Long cpf;
	private String Nome;
	private String dataCriado;
	private static ArrayList<Long> listaProntuario = new ArrayList<Long>();
	private static ArrayList<Prescricao> listaPrescricao = new ArrayList<Prescricao>();
	
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public Paciente(Long cpf, String nome) {
		super();
		this.cpf = cpf;
		this.Nome = nome;
		this.dataCriado = formatter.format(date);
	}
	public void addPron (Long UniqueID) {
		listaProntuario.add(UniqueID);
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
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
	public void addPrescricao(Prescricao P) {
		listaPrescricao.add(P);
	}
	
	@Override
	public String toString() {
		return "Paciente: CPF=" + cpf + ", Nome=" + Nome;
	}
	
	
	
}
