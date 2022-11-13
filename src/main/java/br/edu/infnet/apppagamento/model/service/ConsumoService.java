package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Consumo;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.persistence.ConsumoDAO;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ConsumoService {

	private final ConsumoDAO consumoDAO;

	public ConsumoService(ConsumoDAO consumoDAO) {
		this.consumoDAO = consumoDAO;
	}

	public void incluir(Consumo consumo) {
		consumoDAO.save(consumo);
		AppImpressao.relatorio("Consumo: ", consumo);
	}
	
	
	public Collection<Consumo> obterLista() {
		return (Collection<Consumo>) consumoDAO.listAll();
	}
	public Collection<Consumo> obterLista(Usuario usuario) {
		return (Collection<Consumo>) consumoDAO.getById(usuario.getId());
	}

	public void excluir(Integer id) {
		consumoDAO.delete(id);
	}
}
