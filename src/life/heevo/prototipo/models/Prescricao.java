package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.*;
import java.awt.print.*;
import javax.print.attribute.*;
import javax.swing.UIManager;

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
		String conteudo = "[*] RECEITA DA HEEVO[*]\n";
		for(Medicamento i:medicamentos) {
			conteudo = (conteudo + i.getMedicamento() + "\t" + i.getDosagem() + "\t" + i.getFrequencia() + "\t"
					+ Integer.toString(i.getQtde()) +"\n");
		}
		System.out.println(conteudo);
		try {
			String cn = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(cn); // Use the native L&F
		} catch (Exception cnf) {
		}
		PrinterJob job = PrinterJob.getPrinterJob();
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		PageFormat pf = job.pageDialog(aset); //permite ao usuário formatar a pagina de impressão
		job.setPrintable(new Impressora(conteudo), pf);
		boolean ok = job.printDialog(aset); //abre o setup de impressão
		if (ok) {
			try {
				job.print(aset); //manda imprimir
			} catch (PrinterException ex) {
				/* The job did not successfully complete */
			}
		}
	}
	
}
