package life.heevo.prototipo.DAO;

import java.util.ArrayList;

import life.heevo.prototipo.models.Entrada;
import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.repositorios.impl.EntradaRepositorioJdbc;
import life.heevo.prototipo.repositorios.impl.PacienteRepositorioJdbc;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;

public class EntradaDAO {

	//private static ArrayList<Entrada> entradas = new ArrayList<Entrada>();//lista de entradas
	
	static public void imprimirEntrada(Entrada entrada) {
		System.out.println(entrada.getDataCriado());
		System.out.println("------------------------------------------------------");
		System.out.println(entrada.getDescricao());
	}
	
	static public void novaEntrada (String texto, int idPront) {
		try {
			HeevoRepositorio<Entrada> entradaRepo = new EntradaRepositorioJdbc();
			Entrada entrada = new Entrada();
			entrada.setDescricao(texto);
			entrada.setIDProntuario(idPront);
			entradaRepo.inserir(entrada);
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}
	
	static public void imprimirEntradas (int idPront) {
		try {
			ArrayList<Entrada> entradas = new ArrayList<Entrada>();
			HeevoRepositorio<Entrada> entradaRepo = new EntradaRepositorioJdbc();
			entradas = entradaRepo.listar(idPront);
			for (Entrada i:entradas) {
				System.out.println(i.toString());
		}
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		}
	}
