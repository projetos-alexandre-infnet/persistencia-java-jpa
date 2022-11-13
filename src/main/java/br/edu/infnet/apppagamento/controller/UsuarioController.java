package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

	private UsuarioService service;
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
		model.addAttribute("listagem", service.obterLista());
		return "usuario/lista";
	}
	
	@GetMapping(value = "/usuario")
	public String telaCadastro(Usuario usuario) {
		return "usuario/cadastro";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {
		
		service.incluir(usuario);
		
		return "redirect:/";
	}
	
	@DeleteMapping(value = "/usuario/{email}/excluir")
	public String excluir(@PathVariable String email) {
		
		service.excluir(email);
		
		return "redirect:/usuario/lista";
		
	}
}
