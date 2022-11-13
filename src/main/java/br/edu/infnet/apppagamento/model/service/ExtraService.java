package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Extra;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.repository.ExtraRepository;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExtraService {

	private final ExtraRepository extraRepository;

	public ExtraService(ExtraRepository extraRepository) {
		this.extraRepository = extraRepository;
	}

	public void incluir(Extra extra) {
		extraRepository.save(extra);
		AppImpressao.relatorio("Extra: ", extra);
	}
	
	public Collection<Extra> obterLista() {
		return (Collection<Extra>) extraRepository.findAll();
	}
	public Collection<Extra> obterLista(Usuario usuario) {
		return (Collection<Extra>) extraRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id) {
		extraRepository.deleteById(id);
	}
}