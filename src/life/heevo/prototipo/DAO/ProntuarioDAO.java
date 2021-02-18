package life.heevo.prototipo.DAO;

import java.util.ArrayList;

import life.heevo.prototipo.models.Prontuario;

public class ProntuarioDAO {

	public static ArrayList<Prontuario> listaProntuario = new ArrayList<Prontuario>();
	
	public static Prontuario consultarProntuarioPorCPF(Long CPF, Long CPFPro) {
		long bigCpf = (int) Math.floor(CPF/100); //Descartando os dois últimos digitos
		long bigCpfPro = (int) Math.floor(CPFPro/100);
		long uni = ((bigCpf+bigCpfPro+1)*(bigCpf+bigCpfPro)/2)+bigCpfPro;
		for(Prontuario i:listaProntuario) {
			if(i.getUniqueID()==uni)
				return i;
		}
		return null;
	}
}
