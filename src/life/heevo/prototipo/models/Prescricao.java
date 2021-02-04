package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prescricao {
	private String dataCriado;
	private String nomePP;
	private String CRM;
	private String nomePaciente;
	private static ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();//lista de medicamentos
	
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public Prescricao(String nomePP, String CRM, String nomePaciente) {
		super(); // copiado do Ramon, n sei para que serve
		this.nomePP = nomePP;
		this.nomePaciente = nomePaciente;
		this.CRM = CRM;
		this.dataCriado = formatter.format(date);	
	}
	
	public void addMedicamento (Medicamento med) {
		medicamentos.add(med);
	}
	
	public void removerMedicamento (Medicamento med) {
		medicamentos.remove(med);
		// aqui é necessário entender melhor como vamos juntar o front com o back
		//o usuário deve poder escrever e apagar a receita sem perceber que está 
		//acionando métodos
	}
	
	public void displayPrescricao () {
		System.out.println("\n[*]------------------------------------------------------[*]");
		for(Medicamento i:medicamentos)
			System.out.println(i);
		System.out.println("\n[*]------------------------------------------------------[*]\n");
	}
	
	public void imprimir() {
		// TBC
	}
	
}
