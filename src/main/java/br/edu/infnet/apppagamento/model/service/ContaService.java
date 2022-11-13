package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Conta;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.persistence.ContaDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private ContaDAO contaDAO;

    public ContaService(ContaDAO contaDAO) {
        this.contaDAO = contaDAO;
    }

    public List<Conta> obterLista() {
        return (List<Conta>) contaDAO.listAll();
    }

    public List<Conta> obterLista(Usuario usuario) {
        return (List<Conta>) contaDAO.getById(usuario.getId());
    }

    public void excluir(Integer id) {
        contaDAO.delete(id);
    }
}
