package br.edu.infnet.apppagamento.controller;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ClienteController {
	private final ClienteService clienteService;
	private String mensagem;
	private String tipo;
	public ClienteController(ClienteService service) {
		this.clienteService = service;
	}

	@GetMapping(value = "/cliente/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario user) {
		model.addAttribute("listagem", clienteService.obterLista(user));

		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
        return "cliente/lista";
    }

	@GetMapping(value = "/cliente")
	public String telaCadastro() {
		return "cliente/cadastro";
	}
    
    @PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente, @SessionAttribute("user") Usuario usuario) {

		cliente.setUsuario(usuario);
		
    	clienteService.incluir(cliente);

		mensagem = "Inclusão do cliente " + cliente.getNome() + " realizada com sucesso!!!";
		tipo = "alert-success";
		
		return "redirect:/cliente/lista";
	}
    
    @GetMapping(value = "/cliente/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
    	try {
			clienteService.excluir(id);
			mensagem = "Exclusão do cliente " + id + " realizada com sucesso!!!";
			tipo = "alert-success";
		} catch (Exception e) {
			mensagem = "Impossível realizar a exclusão do cliente " + id + "!!!";
			tipo = "alert-danger";
		}
    	return "redirect:/cliente/lista";
    }
}
