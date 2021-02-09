package life.heevo.prototipo.main;

import java.util.ArrayList;
import java.util.Scanner;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.models.Prontuario;

public class userPP {
	
	static int codMenuPP=0;
	static boolean sairPP=false;
	private static Scanner scanner = new Scanner(System.in);

	
	public static ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
	private static ArrayList<Prontuario> listaProntuario = new ArrayList<Prontuario>();

	public static void menuPP(PP userPP) {
		
		do {
			System.out.println("\n\n[*] Usuário -> "+userPP.toString());
			System.out.println("[*] Menu:");
			System.out.println("[*] 1-Cadastrar Paciente, 2-Listar Pacientes, 3-Prontuário, 99-Sair.");
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
					consultarPaciente();
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
	private static void consultarPaciente() throws Exception {
		if(listaPaciente.isEmpty())throw new Exception("[*] Não há Pacientes cadastrados.\n");
		System.out.println("\n[*]------------------------------------------------------[*]");
		for(Paciente i:listaPaciente)
			System.out.println(i);
		System.out.println("\n[*]------------------------------------------------------[*]\n");
		
	}

	public static void cadastrarPaciente(PP Prof) throws Exception {
		System.out.println("[*] Cadastro de Pacientes.");
		System.out.println("\n Nome: ");
		String nome = scanner.next();
		System.out.println("\n CPF: ");
		Long CPF = scanner.nextLong();
		Paciente existente = consultarPacientePorCPF(CPF);
		if(existente==null) {
			Prof.addProntuario(CPF);
			Paciente novoPac = new Paciente(CPF, nome);

			listaPaciente.add(novoPac);
			System.out.println("\n[*] Paciente cadastrado!\n");
			
		}else throw new Exception("\n[*] Já existe um paciente com este CPF.\n");
		// no caso de já existir paciente, talvez a gente devesse entrar direto no menu do paciente
	}
	
	public static void acessarPaciente(Long CPF) {
		Paciente Paci = consultarPacientePorCPF(CPF);

	}
	
	public static Paciente consultarPacientePorCPF(Long CPF) {
		for(Paciente i:listaPaciente) {
			if(i.getCpf()==CPF)
				return i;
		}
		return null;
	}
}
