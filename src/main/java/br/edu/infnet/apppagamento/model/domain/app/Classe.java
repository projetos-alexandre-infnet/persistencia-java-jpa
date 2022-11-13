package br.edu.infnet.apppagamento.model.domain.app;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

import java.util.ArrayList;
import java.util.List;

public class Classe implements IPrinter {
    private String nome;
    private List<Atributo> atributos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    @Override
    public void impressao() {
        System.out.println("- - "+nome);
        for (Atributo a:
             atributos) {
            a.impressao();
        }
    }
}
