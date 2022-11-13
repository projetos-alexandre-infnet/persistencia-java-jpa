package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Tributo;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.persistence.TributoDAO;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class TributoService {
	private final TributoDAO tributoDAO;

	public TributoService(TributoDAO tributoDAO) {
		this.tributoDAO = tributoDAO;
	}


	public void incluir(Tributo tributo) {
		tributoDAO.save(tributo);
		AppImpressao.relatorio("Tributo: ", tributo);
	}
	
	public Collection<Tributo> obterLista(){
		return (Collection<Tributo>) tributoDAO.listAll();
	}
	public Collection<Tributo> obterLista(Usuario usuario){
		return Arrays.asList(tributoDAO.getById(usuario.getId()));
	}

	public void excluir(Integer id) {
		tributoDAO.delete(id);
	}
}
