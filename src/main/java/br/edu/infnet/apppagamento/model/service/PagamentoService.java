package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Pagamento;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.repository.PagamentoRepository;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PagamentoService {
	private PagamentoRepository pagamentoRepository;
	public PagamentoService(PagamentoRepository pagamentoRepository) {
		this.pagamentoRepository = pagamentoRepository;
	}
	public void incluir(Pagamento pagamento) {
		pagamentoRepository.save(pagamento);

		AppImpressao.relatorio("Inclusão do Pagamento " + pagamento.getId() + " realizada com sucesso!!!", pagamento);
	}

	public Collection<Pagamento> obterLista(){
		return (Collection<Pagamento>) pagamentoRepository.findAll();
	}

	public Collection<Pagamento> obterLista(Usuario usuario){
		return pagamentoRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id){
		pagamentoRepository.deleteById(id);
	}
}
