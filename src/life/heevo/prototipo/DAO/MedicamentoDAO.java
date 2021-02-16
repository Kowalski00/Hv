package life.heevo.prototipo.DAO;

import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.UIManager;

import life.heevo.prototipo.models.Impressora;
import life.heevo.prototipo.models.Medicamento;

public class MedicamentoDAO {

private static ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();//lista de medicamentos
	
	
	public static void addMedicamento (Medicamento med) {
		medicamentos.add(med);
	}
	
	public static void removerMedicamento (Medicamento med) {
		medicamentos.remove(med);
		// aqui é necessário entender melhor como vamos juntar o front com o back
		//o usuário deve poder escrever e apagar a receita sem perceber que está 
		//acionando métodos
	}
	
	public static void displayPrescricao () {
		System.out.println("\n[*]------------------------------------------------------[*]");
		for(Medicamento i:medicamentos)
			System.out.println(i);
		System.out.println("\n[*]------------------------------------------------------[*]\n");
	}
	
	public static void imprimir() {
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
