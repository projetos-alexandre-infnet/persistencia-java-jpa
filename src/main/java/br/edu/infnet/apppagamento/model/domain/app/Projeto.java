package br.edu.infnet.apppagamento.model.domain.app;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

import java.util.ArrayList;
import java.util.List;

public class Projeto implements IPrinter {
    private String nome;
    private String descricaoProjeto;
    private List<Classe> classes = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    @Override
    public void impressao() {
        System.out.println("- - "+nome+" | "+ descricaoProjeto);
        for (Classe c:
             classes) {
            c.impressao();
        }
    }
}
