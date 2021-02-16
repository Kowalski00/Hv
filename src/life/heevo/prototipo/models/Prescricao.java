package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.*;
import java.awt.print.*;
import javax.print.attribute.*;
import javax.swing.UIManager;
/**
 * Representa uma Prescrição
 * 
 * @author hl
 * @author rk
 *
 */
public class Prescricao {
	
	private String dataCriado;
	private String nomePP;
	private String CRM;
	private String nomePaciente;
	
	
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public Prescricao(String nomePP, String CRM, String nomePaciente) {
		this.nomePP = nomePP;
		this.nomePaciente = nomePaciente;
		this.CRM = CRM;
		this.dataCriado = formatter.format(date);	
	}
	
	

	@Override
	public String toString() {
		return "Prescricao: " + dataCriado + ", Profissional: " + nomePP + "( CRM: " + CRM + " ) Paciente: "
				+ nomePaciente;
	}



	public String getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(String dataCriado) {
		this.dataCriado = dataCriado;
	}

	public String getNomePP() {
		return nomePP;
	}

	public void setNomePP(String nomePP) {
		this.nomePP = nomePP;
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	
	
}
