package life.heevo.prototipo.repositorios.impl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import life.heevo.prototipo.models.Paciente;
import life.heevo.prototipo.repositorios.interfaces.HeevoRepositorio;
import life.heevo.prototipo.fabricas.FabricaConexaoJdbc;

public class PacienteRepositorioJdbc implements HeevoRepositorio<Paciente> {

	@Override
	public List<Paciente> listar() throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Paciente entidade) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Paciente entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Paciente entidade) {
		// TODO Auto-generated method stub
		
	}

}
