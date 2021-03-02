package life.heevo.prototipo.repositorios.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import life.heevo.prototipo.models.PP;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;
import life.heevo.prototipo.fabricas.FabricaConexaoJdbc;

public class PPRepositorioJdbc implements HeevoRepositorio<PP> {

	public Object selecionar(long ID) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PP> listar() throws SQLException, IOException {
		ArrayList<PP> pps = new ArrayList<PP>();
		try (Connection conexao = FabricaConexaoJdbc.criarConexao()) {
			Statement comando = conexao.createStatement();
			ResultSet rs = comando.executeQuery("SELECT * FROM pp");
			while (rs.next()) {
				PP prof = new PP();
				prof.setCpf(rs.getLong("CPF"));
				prof.setNome(rs.getString("nome"));
				prof.setCodRegPro(rs.getInt("CRM"));
				pps.add(prof);
			}
		}
		return pps;
	}
	
	@Override
	public void inserir(PP entidade) throws SQLException, IOException {
		try(Connection conexao =FabricaConexaoJdbc.criarConexao())  {
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO pp (CPF, nome, CRM) " + "VALUES (?, ?, ?)");
			comando.setLong(1, entidade.getCpf());// indice jdbc começa em 1, mySQL começa em 0
			comando.setString(2, entidade.getNome());
			comando.setInt(3,  entidade.getCodRegPro());
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
