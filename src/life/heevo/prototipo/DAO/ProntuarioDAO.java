package life.heevo.prototipo.DAO;

import java.util.ArrayList;

import life.heevo.prototipo.models.Prontuario;
import life.heevo.prototipo.repositorios.impl.ProntuarioRepositorioJdbc;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;

public class ProntuarioDAO {

	public static ArrayList<Prontuario> listaProntuario = new ArrayList<Prontuario>();
	
	public static Prontuario consultarProntuarioPorCPF(String CPF, String CPFPro) {
		try {
			HeevoRepositorio<Prontuario> pronRepo = new ProntuarioRepositorioJdbc();
			String cpfCon = CPF + CPFPro;
			Prontuario pron = pronRepo.selecionar(cpfCon);
			return pron;
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		return null;
	}
}
