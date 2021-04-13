package life.heevo.pttp.sb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import life.heevo.pttp.sb.entities.PP;
import life.heevo.pttp.sb.repositories.PPRepo;

@Controller
@RequestMapping("/pp")
public class PPController {
	
	@Autowired
	private PPRepo repo;

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView res = new ModelAndView("pp/index");
		List<PP> listaPP = repo.findAll();
		return res.addObject("listaPP",listaPP);
	}
	@GetMapping("cadastrar")
	public ModelAndView inserir() {
		ModelAndView res = new ModelAndView("pp/cadastro-pp");
		res.addObject("pp", new PP());
		return res;
	}
	
}
