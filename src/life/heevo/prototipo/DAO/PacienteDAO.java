package life.heevo.prototipo.DAO;

import java.util.ArrayList;
import java.util.Scanner;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.models.Prontuario;

public class PacienteDAO {
	
	public static ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void consultarPaciente() throws Exception {
		if(listaPaciente.isEmpty())throw new Exception("[*] Não há Pacientes cadastrados.\n");
		System.out.println("\n[*]------------------------------------------------------[*]");
		for(Paciente i:listaPaciente)
			i.toString();
		System.out.println("\n[*]------------------------------------------------------[*]\n");
	}
	
	public static Paciente consultarPacientePorCPF(Long CPF) {
		for(Paciente i:listaPaciente) {
			if(i.getCpf()==CPF)
				return i;
		}
		return null;
	}
	
	
	public static void cadastrarPaciente(PP Prof) throws Exception {
		System.out.println("[*] Cadastro de Pacientes.");
		System.out.println("\n Nome: ");
		String nome = scanner.next();
		System.out.println("\n CPF: ");
		Long CPF = scanner.nextLong();
		Paciente existente = consultarPacientePorCPF(CPF);
		if(existente==null) {
			
			Paciente novoPac = new Paciente(CPF, nome);
			Prontuario novoProntuario = new Prontuario(nome, CPF, Prof.getCpf());
			Prof.addProntuario(novoProntuario.getUniqueID());
			ProntuarioDAO.listaProntuario.add(novoProntuario);
			listaPaciente.add(novoPac);
			System.out.println("\n[*] Paciente cadastrado!\n");
			
		}else throw new Exception("\n[*] Já existe um paciente com este CPF.\n");
		// no caso de já existir paciente, talvez a gente devesse entrar direto no menu do paciente
	}
	
	

	static int codMenuPront=0;
	static boolean sairMenuPront=false;
	
	public static void acessarPaciente(PP PP) {
		System.out.println("[*] Acessar Paciente");
		System.out.println("\n CPF: ");
		Long CPF = scanner.nextLong();
		Paciente existente = consultarPacientePorCPF(CPF);
		if(existente==null) {
			System.out.println("[*] Este Paciente Ainda Não Foi Cadastrado");
			System.out.println("[*] Gostaria de Cadastrar novo Paciente?");
			System.out.println("[*] 1-Sim; 2-Não");
			int opc = scanner.nextInt();
			if(opc == 1) 
			try{ 
				cadastrarPaciente(PP);
				existente = consultarPacientePorCPF(CPF);
			}catch(Exception e) {
				System.out.println(e);
			}
			else return;
		}
		Prontuario Pron = ProntuarioDAO.consultarProntuarioPorCPF(CPF, PP.getCpf());
		if (Pron==null) {
			Pron = new Prontuario(existente.getNome(),CPF,PP.getCpf());
			ProntuarioDAO.listaProntuario.add(Pron);
			existente.addPron(Pron.getUniqueID());//Adicionando no cadastro do médico e do paciente o prontuario
			PP.addProntuario(Pron.getUniqueID());
		}
		do {
			Long IDPron = Pron.getUniqueID();
			EntradaDAO.imprimirEntradas(IDPron);
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
					EntradaDAO.novaEntrada(entrada, IDPron);
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			}
			
			case 2:{
				try {
					PrescricaoDAO.Prescrever(PP, existente);
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
			}
			case 99:{
				System.out.println("\n[*] Saindo..");
				sairMenuPront=true;
				break;
				}
			}
		}while(sairMenuPront==false);		
	}

}
