package br.edu.infnet.apppagamento.model.domain;


import br.edu.infnet.apppagamento.model.exceptions.ConsumoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.ImpostoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.QuantidadeDeParcelasInvalidaException;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TConsumo")
public class Consumo extends Conta {
	private String item;
	private Integer quantidadeDeItens;
	private String individualOuGrupo;

	public Consumo(Integer id, String descricao, boolean contaAtiva, String item, Integer quantidadeDeItens, String individualOuGrupo) {
		super(id, descricao, contaAtiva);
		this.item = item;
		this.quantidadeDeItens = quantidadeDeItens;
		this.individualOuGrupo = individualOuGrupo;
	}

	public Consumo() {
		super();
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getQuantidadeDeItens() {
		return quantidadeDeItens;
	}

	public void setQuantidadeDeItens(Integer quantidadeDeItens) {
		this.quantidadeDeItens = quantidadeDeItens;
	}

	public String getIndividualOuGrupo() {
		return individualOuGrupo;
	}

	public void setIndividualOuGrupo(String individualOuGrupo) {
		this.individualOuGrupo = individualOuGrupo;
	}

	@Override
	public String toString() {
		return "Item: " + item + "\n Quantidade de Itens: " + quantidadeDeItens + "\n Individual ou Grupo: "
				+ individualOuGrupo + "\n" + super.toString();
	}

	@Override
	public void impressao() {
	}

	@Override
	public boolean mostraContaAtiva()
			throws ConsumoInvalidoException, ImpostoInvalidoException, QuantidadeDeParcelasInvalidaException {
		if(item.isEmpty()) {
			throw new ConsumoInvalidoException("o item vazio faz com que o consumo seja inválido");
		}
		return false;
	}

	

}
