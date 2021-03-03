package life.heevo.prototipo.DAO;

import java.util.Scanner;

import life.heevo.prototipo.models.Medicamento;
import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.models.Prescricao;

public class PrescricaoDAO {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void Prescrever(PP userPP, Paciente existente) {
		Prescricao presc = new Prescricao(userPP.getNome(),userPP.getCodRegPro(),existente.getNome());
		//BUG: SE EU TENTO CRIAR MAIS DE UMA PRESCRICAO NA MESMA SESSÃO, FICA TUDO UMA SÓ
		/*
		 * TODO Criar um do-while para verificar se o PP deseja adicionar uma nova prescrição ou não
		 *      onde em cada while será instanciado um novo objeto de Prescricao
		 */
		boolean cont = true;
		do{
			System.out.println("[*] Digite o medicamento (nome, tipo, dosagem, frequencia, qtde), 99 para terminar:");
			String meds = scanner.next();
			if(meds.equals("99")) cont=false;
			else {
				String tipo = scanner.next();
				String dosagem = scanner.next();
				String frequencia = scanner.next();
				int qtde = scanner.nextInt();
				Medicamento M = new Medicamento(meds, tipo, dosagem, frequencia, qtde);
				MedicamentoDAO.addMedicamento(M);
			}
		} while(cont==true);
		existente.addPrescricao(presc);
		MedicamentoDAO.displayPrescricao();
		MedicamentoDAO.imprimir();
	}
	
}
