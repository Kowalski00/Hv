package life.heevo.prototipo.DAO;

import java.util.ArrayList;
import java.util.Scanner;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.models.Prontuario;
import life.heevo.prototipo.repositorios.impl.PPRepositorioJdbc;
import life.heevo.prototipo.repositorios.impl.PacienteRepositorioJdbc;
import life.heevo.prototipo.repositorios.impl.ProntuarioRepositorioJdbc;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;

public class PacienteDAO {

	public static ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();

	private static Scanner scanner = new Scanner(System.in);

	public static void consultarPaciente() throws Exception {
		try {
			HeevoRepositorio<Paciente> paciRepo = new PacienteRepositorioJdbc();
			listaPaciente = paciRepo.listar();
			if (listaPaciente.isEmpty())
				throw new Exception("[*] Não há Pacientes cadastrados.\n");
			System.out.println("\n[*]------------------------------------------------------[*]");
			for (Paciente i : listaPaciente)
				System.out.println(i.toString());
			System.out.println("\n[*]------------------------------------------------------[*]\n");
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

	public static Paciente consultarPacientePorCPF(String CPF) {
		try {
			HeevoRepositorio<Paciente> paciRepo = new PacienteRepositorioJdbc();
			Paciente paci = paciRepo.selecionar(CPF);
			return paci;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		return null;
	}

	public static void cadastrarPaciente() throws Exception {
		System.out.println("[*] Cadastro de Pacientes.");
		System.out.println("\n Nome: ");
		String nome = scanner.next();
		System.out.println("\n CPF: ");
		String CPF = scanner.next();
		Paciente existente = consultarPacientePorCPF(CPF);
		if (existente == null) {
			try {
				Paciente novoPac = new Paciente();
				novoPac.setCpf(CPF);
				novoPac.setNome(nome);
				// Prontuario novoProntuario = new Prontuario();
				// Prof.addProntuario(novoProntuario.getUniqueID());
				// ProntuarioDAO.listaProntuario.add(novoProntuario);
				// listaPaciente.add(novoPac);
				HeevoRepositorio<Paciente> paciRepo = new PacienteRepositorioJdbc();
				paciRepo.inserir(novoPac);
				System.out.println("\n[*] Paciente cadastrado!\n");
			} catch (Exception e) {
				System.out.println("Erro:" + e.getMessage());
			}
		} else
			throw new Exception("\n[*] Já existe um paciente com este CPF.\n");
		// no caso de já existir paciente, talvez a gente devesse entrar direto no menu
		// do paciente
	}

	static int codMenuPront = 0;
	static boolean sairMenuPront = false;

	
	public static void acessarPaciente(PP PP) {
		System.out.println("[*] Acessar Paciente"); System.out.println("\n CPF: ");
		String CPF = scanner.next(); 
		Paciente existente = consultarPacientePorCPF(CPF); 
		if(existente==null) {
			System.out.println("[*] Este Paciente Ainda Não Foi Cadastrado");
			System.out.println("[*] Gostaria de Cadastrar novo Paciente?");
			System.out.println("[*] 1-Sim; 2-Não"); 
			int opc = scanner.nextInt(); 
			if(opc== 1) 
				try{ 
					cadastrarPaciente(); 
					existente = consultarPacientePorCPF(CPF);
					}catch(Exception e) { 
						System.out.println(e); 
						} 
			else return; 
			} 
		Prontuario Pron	= ProntuarioDAO.consultarProntuarioPorCPF(CPF, PP.getCpf());
		if (Pron==null)
		{
			try {
				Pron = new Prontuario();
				Pron.setNome(existente.getNome());
				Pron.setCpf(CPF);
				Pron.setCpfPro(PP.getCpf());
				HeevoRepositorio<Prontuario> pronRepo = new ProntuarioRepositorioJdbc();
				pronRepo.inserir(Pron);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		do { 
			int IDPron = Pron.getUniqueID(); 
			EntradaDAO.imprimirEntradas(IDPron);
			System.out.println("[*] Menu Prontuario");
			System.out.println("[*] 1-Nova Entrada, 2-Prescrever, 99-Voltar.");
			System.out.print("[*] Selecione uma opção: "); 
			codMenuPront = scanner.nextInt(); 
			scanner.nextLine();  
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
						} catch(Exception e) {
							System.out.println(e); 
							} 
					break; 
					} 
				case 99:{
					System.out.println("\n[*] Saindo.."); sairMenuPront=true; 
					break; } 
				}
			}
		while(sairMenuPront==false); 
		}

}
