package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.service.ContaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ContaController {
	private ContaService contaService;

    public ContaController(ContaService service) {
        this.contaService = service;
    }

    @GetMapping(value = "/conta/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
    	model.addAttribute("listagem", contaService.obterLista(usuario));
        return "conta/lista";
    }

    @GetMapping(value = "/conta/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        contaService.excluir(id);

        return "redirect:/conta/lista";
    }
}
