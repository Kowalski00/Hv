package life.heevo.pttp.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import life.heevo.pttp.sb.entities.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.cpf = :cpf")
	Usuario finByCpf(@Param("cpf") String cpf);
}
