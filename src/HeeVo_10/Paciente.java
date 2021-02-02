package HeeVo_10;
import java.util.*;

public class Paciente {
	String name;
	String CPF;
	String email;
	List<Prontuario> prontuarios = new ArrayList<>();
	
	
	void display() {
		System.out.println("Nome: " +name+" CPF: " +CPF+" Email: " +email);
	}

}
