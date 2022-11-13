package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Pagamento;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.persistence.PagamentoDAO;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class PagamentoService {
	private PagamentoDAO pagamentoDAO;
	public PagamentoService(PagamentoDAO pagamentoDAO) {
		this.pagamentoDAO = pagamentoDAO;
	}
	public void incluir(Pagamento pagamento) {
		pagamentoDAO.save(pagamento);

		AppImpressao.relatorio("Inclusão do Pagamento " + pagamento.getId() + " realizada com sucesso!!!", pagamento);
	}

	public Collection<Pagamento> obterLista(){
		return (Collection<Pagamento>) pagamentoDAO.listAll();
	}

	public Collection<Pagamento> obterLista(Usuario usuario){
		return Arrays.asList(pagamentoDAO.getById(usuario.getId()));
	}

	public void excluir(Integer id){
		pagamentoDAO.delete(id);
	}
}
