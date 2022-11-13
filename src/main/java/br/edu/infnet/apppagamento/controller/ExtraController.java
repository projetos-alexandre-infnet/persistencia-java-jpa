package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.domain.Extra;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.service.ExtraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ExtraController {

	private ExtraService service;

	public ExtraController(ExtraService service) {
		this.service = service;
	}

	@GetMapping(value = "/extra/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("listagem", service.obterLista(usuario));
    	return "extra/lista";
    }

	@GetMapping(value = "/extra")
	public String telaCadastro() {
		return "extra/cadastro";
	}
    
    @PostMapping(value = "/extra/incluir")
	public String incluir(Extra extra, @SessionAttribute("user") Usuario usuario) {
		extra.setUsuario(usuario);
    	service.incluir(extra);
		
		return "redirect:/extra/lista";
	}
    
    @GetMapping(value = "/extra/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
    	service.excluir(id);
    
    	return "redirect:/extra/lista";
    }
}
