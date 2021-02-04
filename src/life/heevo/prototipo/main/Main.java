package life.heevo.prototipo.main;

import java.util.ArrayList;
import java.util.Scanner;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.models.Prontuario;

public class Main {
	//tentando centralizar as listas na main com vias a substituir por database depois
	public static ArrayList<PP> listaPP = new ArrayList<PP>();
	public static ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
	private static ArrayList<Prontuario> listaProntuario = new ArrayList<Prontuario>();
	private static Scanner scanner = new Scanner(System.in);
	// variáveis userPP
	static int codMenuPP=0;
	static boolean sairPP=false;
	//variáveis acessar paciente
	static int codMenuPront=0;
	static boolean sairMenuPront=false;
	
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
		Long cpfPP;
		System.out.println("[*] Digite seu cpf:");
		cpfPP = scanner.nextLong();
		try {
			for(PP i:listaPP) {
				if(i.getCpf()==cpfPP)
					userPP(i);
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}
	
	private static void userPP(PP userPP) {
		do {
			System.out.println("\n\n[*] Usuário -> "+userPP.toString());
			System.out.println("[*] Menu:");
			System.out.println("[*] 1-Cadastrar Paciente, 2-Listar Pacientes, 3-Acessar Paciente, 99-Sair.");
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
					acessarPaciente(userPP);
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
	
	//FUNCOES PACIENTE
	public static void acessarPaciente(PP userPP) {
		System.out.println("[*] Acessar Paciente");
		System.out.println("\n CPF: ");
		Long CPF = scanner.nextLong();
		Paciente existente = consultarPacientePorCPF(CPF);
		if(existente==null) {
			System.out.println("[*] Este Paciente Ainda Não Foi Cadastrado");
			System.out.println("[*] Gostaria de Cadastrar novo Paciente?");
			System.out.println("[*] 1-Sim; 2-Não");
			int opc = scanner.nextInt();
			if(opc == 1) try{ 
				cadastrarPaciente();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		Prontuario Pron = consultarProntuarioPorCPF(CPF, userPP.getCpf());
		if (Pron==null) {
			Pron = new Prontuario(existente.getNome(),CPF,userPP.getCpf());
			listaProntuario.add(Pron);
			existente.addPron(Pron);
		}
		do {
			Pron.imprimirEntradas();
			System.out.println("[*] Menu Prontuario");
			System.out.println("[*] 1-Nova Entrada, 2-Prescrever, 99-Voltar.");
			System.out.print("[*] Selecione uma opção: ");
			codMenuPront = scanner.nextInt();
			scanner.nextLine(); //Para pular de linha, do contrário dá erro quando tentamos adicionar nova entrada
			switch (codMenuPront) {
			case 1:{
				try {
					System.out.println("[*] Digite a Entrada:");
					String entrada = scanner.nextLine();
					Pron.novaEntrada(entrada);
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			}
			case 2:{
				try {
					System.out.println("[*] Digite a Prescrição:");
					

				}catch(Exception e) {
					System.out.println(e);
				}
			}break;
			case 99:{
				System.out.println("\n[*] Saindo..");
				sairMenuPront=true;
				break;
			}
			}
		}while(sairMenuPront==false);		
	}
	
	public static void cadastrarPaciente() throws Exception {
		System.out.println("[*] Cadastro de Pacientes.");
		System.out.println("\n Nome: ");
		String nome = scanner.next();
		System.out.println("\n CPF: ");
		Long CPF = scanner.nextLong();
		Paciente existente = consultarPacientePorCPF(CPF);
		if(existente==null) {
			Paciente novoPac = new Paciente(CPF, nome);
			listaPaciente.add(novoPac);
			System.out.println("\n[*] Paciente cadastrado!\n");	
		}else throw new Exception("\n[*] Já existe um paciente com este CPF.\n");
		// no caso de já existir paciente, talvez a gente devesse entrar direto no menu do paciente
		// aqui tb é bom ter um menu "voltar"
	}
	
	private static void consultarPaciente() throws Exception {
		if(listaPaciente.isEmpty())throw new Exception("[*] Não há Pacientes cadastrados.\n");
		System.out.println("\n[*]------------------------------------------------------[*]");
		for(Paciente i:listaPaciente)
			System.out.println(i);
		System.out.println("\n[*]------------------------------------------------------[*]\n");	
	}
	
	public static Paciente consultarPacientePorCPF(Long CPF) {
		for(Paciente i:listaPaciente) {
			if(i.getCpf()==CPF)
				return i;
		}
		return null;
	}
	
	//FUNCOES PP
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
		Long CPF = scanner.nextLong();
		System.out.println("\n CodReg: ");
		int CodReg = scanner.nextInt();
		PP existente = consultarPPporCPF(CPF);
		if(existente==null) {
			PP novoPP = new PP(nome, CPF, CodReg);
			listaPP.add(novoPP);
			System.out.println("\n[*] Profissional cadastrado!\n");
		}else throw new Exception("\n[*] Já existe um profissional com este CPF.\n");
		
	}
	
	public static PP consultarPPporCPF(Long CPF) {
		for(PP i:listaPP) {
			if(i.getCpf()==CPF)
				return i;
		}
		return null;
	}

	//FUNCOES PRONTUARIO
	public static Prontuario consultarProntuarioPorCPF(Long CPF, Long CPFPro) {
		long bigCpf = (int) Math.floor(CPF/100); //Descartando os dois últimos digitos
		long bigCpfPro = (int) Math.floor(CPFPro/100);
		long uni = ((bigCpf+bigCpfPro+1)*(bigCpf+bigCpfPro)/2)+bigCpfPro;
		for(Prontuario i:listaProntuario) {
			if(i.getUniqueID()==uni)
				return i;
		}
		return null;
	}
	
}
