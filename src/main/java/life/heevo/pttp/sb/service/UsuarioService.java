package life.heevo.pttp.sb.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.heevo.pttp.sb.entities.Usuario;
import life.heevo.pttp.sb.repositories.UsuarioRepo;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepo repo;
	
	@Transactional(readOnly = true)
	public Usuario buscarPorCpf(String cpf) {
		return repo.finByCpf(cpf);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = buscarPorCpf(username);
		
		return new User(
				usuario.getCpf(),
				usuario.getPassword(),
				AuthorityUtils.createAuthorityList(getAuthorities(usuario))
			);
	}
	
	private String[] getAuthorities(List<Perfis> perfis) {
		String[] authorities = new String[perfis.size()];
		for (int i = 0; i < perfis.size(); i++) {
			authorities[i] = perfis.get(i).getDesc();
		}
		return authorities;
	}
	
	
}
