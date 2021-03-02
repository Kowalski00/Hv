package life.heevo.prototipo.repositorios.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface HeevoRepositorio<T> {

	//T selecionar(long ID) throws SQLException, IOException; //Recupera os dados de uma entidade
	List<T> listar() throws SQLException, IOException;		// Lista os dados de todas as entidades
	void inserir(T entidade) throws SQLException, IOException;//Insere uma nova entidade
	void atualizar(T entidade);								//Atualiza os dados de uma entidade
	void excluir(T entidade);								// Exclui uma entidade
	
}