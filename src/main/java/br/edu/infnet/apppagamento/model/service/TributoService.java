package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Tributo;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.repository.TributoRepository;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TributoService {
	private final TributoRepository tributoRepository;

	public TributoService(TributoRepository tributoRepository) {
		this.tributoRepository = tributoRepository;
	}


	public void incluir(Tributo tributo) {
		tributoRepository.save(tributo);
		AppImpressao.relatorio("Tributo: ", tributo);
	}
	
	public Collection<Tributo> obterLista(){
		return (Collection<Tributo>) tributoRepository.findAll();
	}
	public Collection<Tributo> obterLista(Usuario usuario){
		return (Collection<Tributo>) tributoRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id) {
		tributoRepository.deleteById(id);
	}
}
