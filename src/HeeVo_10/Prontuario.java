package HeeVo_10;

import java.util.*;

public class Prontuario {
	String CPFPaciente;
	String CPFProfissional;
	List<Entrada> Entradas = new ArrayList<>();
	
	void novaEntrada(String cont) {
		Entrada Entr = new Entrada();
		Entr.conteudo = cont;
		Entradas.add(Entr);
	}
	
	void display() {
		for (int i=0; i<Entradas.size(); i = i+1){
			Entradas.get(i).display();
		}			
	}
}
