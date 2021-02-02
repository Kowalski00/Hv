package life.heevo.prototipo.main;

import java.util.ArrayList;
import java.util.Scanner;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.models.Paciente;

public class userPP {
	
	static int codMenuPP=0;
	static boolean sairPP=false;
	private static Scanner scanner = new Scanner(System.in);
	
	public static ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
	

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
					cadastrarPaciente();
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

	public static void cadastrarPaciente() throws Exception {
		System.out.println("[*] Cadastro de Pacientes.");
		System.out.println("\n Nome: ");
		String nome = scanner.next();
		System.out.println("\n CPF: ");
		int CPF = scanner.nextInt();
		Paciente existente = consultarPacientePorCPF(CPF);
		if(existente==null) {
			Paciente novoPac = new Paciente(CPF, nome);
			listaPaciente.add(novoPac);
			System.out.println("\n[*] Profissional cadastrado!\n");
		}else throw new Exception("\n[*] Já existe um profissional com este CPF.\n");
		
	}
	public static Paciente consultarPacientePorCPF(int CPF) {
		for(Paciente i:listaPaciente) {
			if(i.getCpf()==CPF)
				return i;
		}
		return null;
	}
}
