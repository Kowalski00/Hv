package life.heevo.prototipo.repositorios.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import life.heevo.prototipo.fabricas.FabricaConexaoJdbc;
import life.heevo.prototipo.models.Entrada;
import life.heevo.prototipo.models.Prontuario;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;

public class EntradaRepositorioJdbc implements HeevoRepositorio<Entrada> {

	@Override
	public Entrada selecionar(String ID) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Entrada> listar(int pronId) throws SQLException, IOException {
		ArrayList<Entrada> entradas = new ArrayList<Entrada>();
		try (Connection conexao = FabricaConexaoJdbc.criarConexao()) {
			PreparedStatement comando = conexao.prepareStatement("SELECT * FROM entradas WHERE IDptr = (?)");
			comando.setInt(1,pronId);
			ResultSet rs = comando.executeQuery();
			while (rs.next()) {
				Entrada entrada = new Entrada();
				entrada.setDataCriado(rs.getString("DTcriado"));
				entrada.setDescricao(rs.getString("descricao"));
				entradas.add(entrada);
			}
		}
		return entradas;
	}

	@Override
	public void inserir(Entrada entidade) throws SQLException, IOException {
		try(Connection conexao =FabricaConexaoJdbc.criarConexao())  {
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO entradas (IDptr, descricao) " + "VALUES (?, ?)");
			comando.setInt(1, entidade.getIDProntuario());// indice jdbc começa em 1, mySQL começa em 0
			comando.setString(2, entidade.getDescricao());
			comando.execute();
		} 
	}

	@Override
	public void atualizar(Entrada entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Entrada entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Entrada> listar() throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
