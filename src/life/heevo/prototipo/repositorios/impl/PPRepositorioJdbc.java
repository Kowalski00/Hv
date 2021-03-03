package life.heevo.prototipo.repositorios.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;
import life.heevo.prototipo.fabricas.FabricaConexaoJdbc;

public class PPRepositorioJdbc implements HeevoRepositorio<PP> {

	public PP selecionar(String ID) throws SQLException, IOException {
		PP prof = new PP();
		try (Connection conexao = FabricaConexaoJdbc.criarConexao()) {
			PreparedStatement comando = conexao.prepareStatement("SELECT * FROM pps WHERE CPFpp = (?)");
			comando.setString(1, ID);
			ResultSet rs = comando.executeQuery();
			rs.next(); //O result set inicia com o cursor acima da primeira linha de resultados
			prof.setCpf(rs.getString("CPFpp"));
			prof.setNome(rs.getString("NOMpp"));
			prof.setCodRegPro(rs.getString("codregpro"));
		}
		return prof;
	}

	public ArrayList<PP> listar() throws SQLException, IOException {
		ArrayList<PP> pps = new ArrayList<PP>();
		try (Connection conexao = FabricaConexaoJdbc.criarConexao()) {
			Statement comando = conexao.createStatement();
			ResultSet rs = comando.executeQuery("SELECT * FROM pps");
			while (rs.next()) {
				PP prof = new PP();
				prof.setCpf(rs.getString("CPFpp"));
				prof.setNome(rs.getString("NOMpp"));
				prof.setCodRegPro(rs.getString("codregpro"));
				pps.add(prof);
			}
		}
		return pps;
	}
	
	@Override
	public void inserir(PP entidade) throws SQLException, IOException {
		try(Connection conexao =FabricaConexaoJdbc.criarConexao())  {
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO pps (NOMpp, CPFpp, codregpro) " + "VALUES (?, ?, ?)");
			comando.setString(2, entidade.getCpf());// indice jdbc começa em 1, mySQL começa em 0
			comando.setString(1, entidade.getNome());
			comando.setString(3,  entidade.getCodRegPro());
			comando.execute();
		} 
	}
	
	@Override
	public void atualizar(PP entidade) {
		return;
		
	}
	
	@Override
	public void excluir(PP entidade) {
		return;
		
	}

}
