package HeeVo_10;
import java.util.*;

public class Profissional {
	String name;
	String CPF;
	String email;
	List<Prontuario> Prontuarios = new ArrayList<>();
	List<Paciente> Pacientes = new ArrayList<>();
	
	void display() {
		System.out.println("Nome: " +name+" CPF: " +CPF+" Email: " +email);
	}
	
	Prontuario novoProntuario(String CPFPaciente) {
		
		Prontuario Pron = new Prontuario();
		Pron.CPFProfissional = CPF;
		Pron.CPFPaciente = CPFPaciente;
		Pron.novaEntrada("PACIENTE CADASTRADO");
		Prontuarios.add(Pron);
		return Pron;
			}
	

}
