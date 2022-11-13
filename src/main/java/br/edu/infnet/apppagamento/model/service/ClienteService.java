package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.persistence.ClienteDAO;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class ClienteService {

	private ClienteDAO clienteDAO;

	public ClienteService(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public void incluir(Cliente cliente) {
		clienteDAO.save(cliente);
		AppImpressao.relatorio("Cliente: ", cliente);
	}
	
	public Collection<Cliente> obterLista() {
		return (Collection<Cliente>) clienteDAO.listAll();
	}

	public Collection<Cliente> obterLista(Usuario usuario) {
		return Arrays.asList(clienteDAO.getById(usuario.getId()));
	}

	public void excluir(Integer id) {
		clienteDAO.delete(id);
	}

}
