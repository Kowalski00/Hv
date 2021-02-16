package life.heevo.prototipo.DAO;

import life.heevo.prototipo.models.Entrada;

public class EntradaDAO {

	static public void imprimirEntrada(Entrada entrada) {
		System.out.println(entrada.getDataCriado());
		System.out.println("------------------------------------------------------");
		System.out.println(entrada.getDescricao());
	}
}
