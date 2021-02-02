package life.heevo.prototipo.main;

import java.util.ArrayList;
import java.util.Scanner;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.models.Paciente;

public class Main {

	public static ArrayList<PP> listaPP = new ArrayList<PP>();
	private static Scanner scanner = new Scanner(System.in);
	
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
					cadastrarPP();
				}catch(Exception e) {
					System.out.println(e);
				}
					
				break;
			}
			case 2:{
				try {
					consultarPP();
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

	private static void logar() {
		int cpfPP;
		System.out.println("[*] Digite seu cpf:");
		cpfPP = scanner.nextInt();
		try {
			for(PP i:listaPP) {
				if(i.getCpf()==cpfPP)
					userPP.menuPP(i);
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

	private static void consultarPP() throws Exception {
		if(listaPP.isEmpty())throw new Exception("[*] Não há PP's cadastrados.\n");
		System.out.println("\n[*]------------------------------------------------------[*]");
		for(PP i:listaPP)
			System.out.println(i);
		System.out.println("\n[*]------------------------------------------------------[*]\n");
		
	}

	public static void cadastrarPP() throws Exception {
		System.out.println("[*] Cadastro de Profissionais Prescritores.");
		System.out.println("\n Nome: ");
		String nome = scanner.next();
		System.out.println("\n CPF: ");
		int CPF = scanner.nextInt();
		System.out.println("\n CodReg: ");
		int CodReg = scanner.nextInt();
		PP existente = consultarPPporCPF(CPF);
		if(existente==null) {
			PP novoPP = new PP(nome, CPF, CodReg);
			listaPP.add(novoPP);
			System.out.println("\n[*] Profissional cadastrado!\n");
		}else throw new Exception("\n[*] Já existe um profissional com este CPF.\n");
		
	}
	
	public static PP consultarPPporCPF(int CPF) {
		for(PP i:listaPP) {
			if(i.getCpf()==CPF)
				return i;
		}
		return null;
	}

}
