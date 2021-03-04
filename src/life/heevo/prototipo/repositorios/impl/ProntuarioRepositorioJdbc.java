package life.heevo.prototipo.repositorios.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import life.heevo.prototipo.fabricas.FabricaConexaoJdbc;
import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.models.Prontuario;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;

public class ProntuarioRepositorioJdbc implements HeevoRepositorio<Prontuario> {

	@Override
	public Prontuario selecionar(String ID) throws SQLException, IOException {
		String cpfPaci = ID.substring(0,11);
		String cpfPro = ID.substring(11,22);
		try(Connection conexao =FabricaConexaoJdbc.criarConexao())  {
			Prontuario pron = new Prontuario();
			int IDpp=0;
			int IDpct=0;
			PreparedStatement comando = conexao.prepareStatement("SELECT * FROM pacientes WHERE CPFpct = (?)");
			comando.setString(1, cpfPaci);
			ResultSet rs = comando.executeQuery();
			if (rs.next()) {
				IDpct = rs.getInt("IDpct");
			} else return null;
			PreparedStatement comando2 = conexao.prepareStatement("SELECT * FROM pps WHERE CPFpp = (?)");
			comando2.setString(1, cpfPro);
			ResultSet rs2 = comando2.executeQuery();
			if (rs2.next()) {
				IDpp = rs2.getInt("IDpp");
			} else return null;
			PreparedStatement comando3 = conexao.prepareStatement("SELECT * FROM prontuarios WHERE IDpp = (?) AND IDpct = (?) ");
			comando3.setInt(1,IDpp);// indice jdbc começa em 1, mySQL começa em 0
			comando3.setInt(2,IDpct);
			ResultSet rs3 = comando3.executeQuery();
			if (rs3.next()) {
				pron.setUniqueID(rs3.getInt("IDptr"));
				pron.setDataCriado(rs3.getString("DTcriado"));
				return pron;
			}
		} 		
		return null;
	}

	@Override
	public ArrayList<Prontuario> listar() throws SQLException, IOException {
		ArrayList<Prontuario> prontuarios = new ArrayList<Prontuario>();
		try (Connection conexao = FabricaConexaoJdbc.criarConexao()) {
			Statement comando = conexao.createStatement();
			ResultSet rs = comando.executeQuery("SELECT * FROM prontuarios");
			while (rs.next()) {
				Prontuario prontuario = new Prontuario();
				prontuario.setUniqueID(rs.getInt("IDptr"));
				prontuario.setDataCriado(rs.getString("DTcriado"));
				prontuarios.add(prontuario);
			}
		}
		return prontuarios;
	}

	@Override
	public void inserir(Prontuario entidade) throws SQLException, IOException {
		try(Connection conexao =FabricaConexaoJdbc.criarConexao())  {
			int IDpp=0;
			int IDpct=0;
			PreparedStatement comando = conexao.prepareStatement("SELECT * FROM pacientes WHERE CPFpct = (?)");
			comando.setString(1, entidade.getCpf());
			ResultSet rs = comando.executeQuery();
			if (rs.next()) {
				IDpct = rs.getInt("IDpct");
			}
			PreparedStatement comando2 = conexao.prepareStatement("SELECT * FROM pps WHERE CPFpp = (?)");
			comando2.setString(1, entidade.getCpfPro());
			ResultSet rs2 = comando2.executeQuery();
			if (rs2.next()) {
				IDpp = rs2.getInt("IDpp");
			}
			PreparedStatement comando3 = conexao.prepareStatement("INSERT INTO prontuarios (IDpp, IDpct) " + "VALUES (?, ?)");
			comando3.setInt(1,IDpp);// indice jdbc começa em 1, mySQL começa em 0
			comando3.setInt(2,IDpct);
			comando3.execute();
		} 	
	}

	@Override
	public void atualizar(Prontuario entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Prontuario entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Prontuario> listar(int ID) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
