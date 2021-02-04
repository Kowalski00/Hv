package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.math.*;


public class Prontuario {
	private Long uniqueID; //Identificador do Prontuário
	private String dataCriado; // Data de criação do prontuário (não da entrada)
	private Long cpf; // CPF do paciente
	private Long cpfPro; // CPF do profissional
	private String nome; //nome do paciente
	private static ArrayList<Entrada> entradas = new ArrayList<Entrada>();//lista de entradas
	
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public Prontuario (String nome, Long cpf, Long cpfPro) {
		super(); // COPIEI DO PP, PARA QUE SERVE?
		this.cpf = cpf;
		this.cpfPro = cpfPro;
		this.nome = nome;
		this.dataCriado = formatter.format(date);		
		long bigCpf = (int) Math.floor(cpf/100); //Descartando os dois últimos digitos
		long bigCpfPro = (int) Math.floor(cpfPro/100);
		long uni = ((bigCpf+bigCpfPro+1)*(bigCpf+bigCpfPro)/2)+bigCpfPro;
		this.uniqueID = uni; //Esse é um indicador único do Prontuário
	}
	
	public void novaEntrada (String texto) {
		Entrada novaEntrada = new Entrada(texto);
		entradas.add(novaEntrada);
	}
	
	public void imprimirEntradas () {
		for (Entrada i:entradas) {
			i.imprimirEntrada();
		}
	}

	public Long getUniqueID() {
		return uniqueID;
	}

	public Long getCpf() {
		return cpf;
	}
	
	public Long getCpfPro() {
		return cpfPro;
	}
	
	public String getDataCriado() {
		return dataCriado;
	}
	
	public String getNome() {
		return nome;
	}
	
}
