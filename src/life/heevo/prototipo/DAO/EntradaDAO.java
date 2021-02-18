package life.heevo.prototipo.DAO;

import java.util.ArrayList;

import life.heevo.prototipo.models.Entrada;

public class EntradaDAO {

	private static ArrayList<Entrada> entradas = new ArrayList<Entrada>();//lista de entradas
	
	static public void imprimirEntrada(Entrada entrada) {
		System.out.println(entrada.getDataCriado());
		System.out.println("------------------------------------------------------");
		System.out.println(entrada.getDescricao());
	}
	
	static public void novaEntrada (String texto, Long ID) {
		Entrada novaEntrada = new Entrada(texto, ID);
		entradas.add(novaEntrada);
	}
	
	static public void imprimirEntradas (Long idPront) {
		for (Entrada i:entradas) {
			if(i.getIDProntuario().equals(idPront))
				i.toString();
		}
	}
}
