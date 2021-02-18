package life.heevo.prototipo.main;

import java.util.Scanner;

import life.heevo.prototipo.DAO.PacienteDAO;
import life.heevo.prototipo.models.PP;

public class userPP {
	
	static int codMenuPP=0;
	static boolean sairPP=false;
	private static Scanner scanner = new Scanner(System.in);

	public static void menuPP(PP userPP) {
		
		do {
			System.out.println("\n\n[*] Usuário -> "+userPP.toString());
			System.out.println("[*] Menu:");
			System.out.println("[*] 1-Cadastrar Paciente, 2-Listar Pacientes, 3-Prontuário, 99-Voltar.");
			System.out.print("[*] Selecione uma opção: ");
			codMenuPP = scanner.nextInt();
			switch (codMenuPP) {
			case 1:{
				try {

					
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			}
			case 2:{
				try {
					PacienteDAO.consultarPaciente();
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			}
			case 3:{
				try {
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			}
			case 99:{
				System.out.println("\n[*] Saindo..");
				sairPP=true;
				break;
				}
			}
		} while (!sairPP);
	}
	
}
