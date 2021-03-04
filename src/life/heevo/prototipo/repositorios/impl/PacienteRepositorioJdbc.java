package life.heevo.prototipo.repositorios.impl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;
import life.heevo.prototipo.fabricas.FabricaConexaoJdbc;

public class PacienteRepositorioJdbc implements HeevoRepositorio<Paciente> {

	@Override
	public ArrayList<Paciente> listar() throws SQLException, IOException {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		try (Connection conexao = FabricaConexaoJdbc.criarConexao()) {
			Statement comando = conexao.createStatement();
			ResultSet rs = comando.executeQuery("SELECT * FROM pacientes");
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setCpf(rs.getString("CPFpct"));
				paciente.setNome(rs.getString("NOMpct"));
				paciente.setDataCriado(rs.getString("DTcriado"));
				pacientes.add(paciente);
			}
		}
		return pacientes;
	}

	@Override
	public void inserir(Paciente entidade) throws SQLException, IOException {
		try(Connection conexao =FabricaConexaoJdbc.criarConexao())  {
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO pacientes (NOMpct, CPFpct) " + "VALUES (?, ?)");
			comando.setString(2, entidade.getCpf());// indice jdbc começa em 1, mySQL começa em 0
			comando.setString(1, entidade.getNome());
			comando.execute();
		} 	
	}

	@Override
	public void atualizar(Paciente entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Paciente entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente selecionar(String ID) throws SQLException, IOException {
		Paciente paci = new Paciente();
		try (Connection conexao = FabricaConexaoJdbc.criarConexao()) {
			PreparedStatement comando = conexao.prepareStatement("SELECT * FROM pacientes WHERE CPFpct = (?)");
			comando.setString(1, ID);
			ResultSet rs = comando.executeQuery();
			 // O result set inicia com o cursor acima da primeira linha de resultados
			if (rs.next()) { 
				paci.setCpf(rs.getString("CPFpct"));
				paci.setNome(rs.getString("NOMpct"));
				paci.setDataCriado(rs.getString("DTcriado"));
			} else {
				return null;
			}
		}
		return paci;
	}

	@Override
	public ArrayList<Paciente> listar(int ID) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
