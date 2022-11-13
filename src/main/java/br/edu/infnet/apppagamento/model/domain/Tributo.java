package br.edu.infnet.apppagamento.model.domain;


import br.edu.infnet.apppagamento.model.exceptions.ConsumoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.ImpostoInvalidoException;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "TTributo")
public class Tributo extends Conta {
	private BigDecimal ICMS;
	private BigDecimal IOF;
	private BigDecimal ISS;

	public Tributo(Integer id, String descricao, boolean contaAtiva, BigDecimal ICMS, BigDecimal IOF, BigDecimal ISS) {
		super(id, descricao, contaAtiva);
		this.ICMS = ICMS;
		this.IOF = IOF;
		this.ISS = ISS;
	}

	public Tributo() {
	}

	public Tributo(BigDecimal iCMS, BigDecimal iOF, BigDecimal iSS) {
		super();
		ICMS = iCMS;
		IOF = iOF;
		ISS = iSS;
	}

	public BigDecimal getICMS() {
		return ICMS;
	}

	public void setICMS(BigDecimal iCMS) {
		ICMS = iCMS;
	}

	public BigDecimal getIOF() {
		return IOF;
	}

	public void setIOF(BigDecimal iOF) {
		IOF = iOF;
	}

	public BigDecimal getISS() {
		return ISS;
	}

	public void setISS(BigDecimal iSS) {
		ISS = iSS;
	}

	@Override
	public void impressao() {
		System.out.println("#Tributo");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "ICMS: R$ " + ICMS + ", IOF: R$ " + IOF + ", ISS: R$ " + ISS + "\n" + super.toString();
	}

	@Override
	public boolean mostraContaAtiva() throws ConsumoInvalidoException, ImpostoInvalidoException {
		if(ICMS==BigDecimal.ZERO) throw new ImpostoInvalidoException("");
		return true;
	}

}
