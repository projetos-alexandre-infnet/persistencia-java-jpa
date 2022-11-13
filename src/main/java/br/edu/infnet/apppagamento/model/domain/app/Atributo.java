package br.edu.infnet.apppagamento.model.domain.app;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

public class Atributo implements IPrinter {

    public Atributo(String nome, String tipo, String descricaoAtributo) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricaoAtributo = descricaoAtributo;
    }

    private String nome;
    private String tipo;
    private String descricaoAtributo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricaoAtributo() {
        return descricaoAtributo;
    }

    public void setDescricaoAtributo(String descricaoAtributo) {
        this.descricaoAtributo = descricaoAtributo;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s", nome, tipo, descricaoAtributo);
    }

    @Override
    public void impressao() {
        System.out.println("- - - "+this);
    }
}
