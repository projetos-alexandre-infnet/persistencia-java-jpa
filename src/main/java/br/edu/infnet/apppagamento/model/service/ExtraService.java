package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Extra;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.persistence.ExtraDAO;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExtraService {

	private final ExtraDAO extraDAO;

	public ExtraService(ExtraDAO extraDAO) {
		this.extraDAO = extraDAO;
	}

	public void incluir(Extra extra) {
		extraDAO.save(extra);
		AppImpressao.relatorio("Extra: ", extra);
	}
	
	public Collection<Extra> obterLista() {
		return (Collection<Extra>) extraDAO.listAll();
	}
	public Collection<Extra> obterLista(Usuario usuario) {
		return (Collection<Extra>) extraDAO.getById(usuario.getId());
	}

	public void excluir(Integer id) {
		extraDAO.delete(id);
	}
}