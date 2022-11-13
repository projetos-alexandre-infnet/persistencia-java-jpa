package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.repository.ClienteRepository;
import br.edu.infnet.apppagamento.model.repository.UsuarioRepository;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public void incluir(Cliente cliente) {
		clienteRepository.save(cliente);
		AppImpressao.relatorio("Cliente: ", cliente);
	}
	
	public Collection<Cliente> obterLista() {
		return (Collection<Cliente>) clienteRepository.findAll();
	}

	public Collection<Cliente> obterLista(Usuario usuario) {
		return clienteRepository.obterLista(usuario.getId());
	}

	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}

}
