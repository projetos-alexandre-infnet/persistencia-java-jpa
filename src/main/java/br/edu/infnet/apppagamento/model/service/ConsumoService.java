package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Consumo;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.repository.ConsumoRepository;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConsumoService {

	private final ConsumoRepository consumoRepository;

	public ConsumoService(ConsumoRepository consumoRepository) {
		this.consumoRepository = consumoRepository;
	}

	public void incluir(Consumo consumo) {
		consumoRepository.save(consumo);
		AppImpressao.relatorio("Consumo: ", consumo);
	}
	
	
	public Collection<Consumo> obterLista() {
		return (Collection<Consumo>) consumoRepository.findAll();
	}
	public Collection<Consumo> obterLista(Usuario usuario) {
		return (Collection<Consumo>) consumoRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id) {
		consumoRepository.deleteById(id);
	}
}
