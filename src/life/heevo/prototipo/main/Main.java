package life.heevo.prototipo.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import life.heevo.prototipo.DAO.EntradaDAO;
import life.heevo.prototipo.DAO.MedicamentoDAO;
import life.heevo.prototipo.DAO.PPDAO;
import life.heevo.prototipo.DAO.PacienteDAO;
import life.heevo.prototipo.models.Medicamento;
import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.models.Prescricao;
import life.heevo.prototipo.models.Prontuario;

public class Main {
	
	
	private static Scanner scanner = new Scanner(System.in);
	// variáveis userPP
	static int codMenuPP=0;
	static boolean sairPP=false;
	
	final static String ESC = "\033[";
	 

	public static void main(String[] args) throws Exception{

		boolean sair = false;
		int codMenu = 0;


		System.out.println("|-------------------------------|");
		System.out.println("\n        HEEVO - Protótipo    \n");
		System.out.println("|-------------------------------|");


		do {
			
			System.out.println("\n\n[*] Menu:");
			System.out.println("[*] 1-Cadastrar PP, 2-Listar PP, 3-Logar, 99-Sair.");
			System.out.print("[*] Selecione uma opção: ");
			codMenu = scanner.nextInt();
			switch (codMenu) {
			case 1:{
				try {
					PPDAO.cadastrarPP();
				}catch(Exception e) {
					System.out.println(e);
				}
					
				break;
			}
			case 2:{
				try {
					PPDAO.consultarPP();
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			}
			case 3:{
				try {
					logar();
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			}
			case 99:{
				System.out.println("\n[*] Saindo..");
				sair=true;
				break;
			}
			}
		} while (!sair);
	}

	private static void logar() throws Exception{
		List<PP> listaPP = PPDAO.listaPP();
		if(listaPP.isEmpty())throw new Exception("[*] Não há Profissionias cadastrados.\n");
		String cpfPP;
		System.out.println("[*] Digite seu cpf:");
		cpfPP = scanner.next();
		PP pp = PPDAO.consultarPPporCPF(cpfPP);
		if( pp != null) userPP.menuPP(pp);
		else throw new Exception("[*] CPF não encontrado.");
	}
	
	
}


