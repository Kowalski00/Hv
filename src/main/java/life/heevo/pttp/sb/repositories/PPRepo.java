package life.heevo.pttp.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import life.heevo.pttp.sb.entities.PP;

public interface PPRepo extends JpaRepository<PP, Long>{

	/**
	 * Spring Data creates a new Repository implementation, it analyzes all the methods defined by the interfaces and tries to automatically generate queries from the method name.
	 * So the method name should be findByCpf and not findByCPF.
	 */
	PP findByCpf(String cpf);
}
