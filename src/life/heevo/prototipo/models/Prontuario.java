package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import life.heevo.prototipo.DAO.EntradaDAO;


/**
 * Representa um prontuário
 * 
 * @author hl
 * @author rk
 *
 */
public class Prontuario {
	private String uniqueID; //Identificador do Prontuário
	private String dataCriado; // Data de criação do prontuário (não da entrada)
	private String cpf; // CPF do paciente
	private String cpfPro; // CPF do profissional
	private String nome; //nome do paciente
	
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public Prontuario () {
		this.dataCriado = formatter.format(date);
	}
	

	public String getUniqueID() {
		return uniqueID;
	}
	
	public void setUniqueID(String uniId) {
		this.uniqueID = uniId;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf (String CPF) {
		this.cpf = CPF;
	}
	
	public String getCpfPro() {
		return cpfPro;
	}
	
	public void setCpfPro(String CPFPro){
		this.cpfPro = CPFPro;
	}
	
	public String getDataCriado() {
		return dataCriado;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
}
