package life.heevo.prototipo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Entrada {
	private String dataCriado; // Data de criação da entrada
	private String entrada; // texto da entrada
	
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public Entrada(String texto) {
		this.entrada = texto;
		this.dataCriado = formatter.format(date);	
	}
	
	public void imprimirEntrada() {
		System.out.println(dataCriado);
		System.out.println("------------------------------------------------------");
		System.out.println(entrada);
	}
}
