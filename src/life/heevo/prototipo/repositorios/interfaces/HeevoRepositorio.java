package life.heevo.prototipo.repositorios.interfaces;

import java.io.IOException;
import java.sql.SQLException;

public interface HeevoRepositorio<T> {

	T selecionar(int ID) throws SQLException, IOException;
	void inserir(T entidade) throws SQLException, IOException;
	void atualizar(T entidade);
	void excluir(T entidade);
	
}
