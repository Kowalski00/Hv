package life.heevo.pttp.sb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import life.heevo.pttp.sb.entities.Usuario;

@Controller
@RequestMapping("u")
public class UsuarioController {

	@GetMapping("/novo/cadastro/usuario")
	public String cadastroPorAdminParaAdminPpPaciente(Usuario usuario) {
		return "usuario/cadastro";
	}
}
