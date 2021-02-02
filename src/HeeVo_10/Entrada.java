package HeeVo_10;

import java.time.LocalDateTime;

public class Entrada {
	
	LocalDateTime Dia = LocalDateTime.now();
	String conteudo;

	void display() {
		System.out.println(Dia +"\n");
		System.out.println(conteudo);
	}
}
