package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.domain.Consumo;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.service.ConsumoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ConsumoController {
	private ConsumoService service;
	public ConsumoController(ConsumoService service) {
		this.service = service;
	}

    @GetMapping(value = "/consumo/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("listagem", service.obterLista(usuario));
        return "consumo/lista";
    }

	@GetMapping(value = "/consumo")
	public String telaCadastro(){ return "consumo/cadastro";}
    
    @PostMapping(value = "/consumo/incluir")
	public String incluir(Consumo consumo, @SessionAttribute("user") Usuario usuario) {
		consumo.setUsuario(usuario);
    	service.incluir(consumo);
		return "redirect:/consumo/lista";
	}
    
    @GetMapping(value = "/consumo/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
    	service.excluir(id);
    	return "redirect:/consumo/lista";
    }
}
