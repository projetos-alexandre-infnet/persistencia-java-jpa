package br.edu.infnet.apppagamento.model.domain;

import br.edu.infnet.apppagamento.interfaces.IPrinter;
import br.edu.infnet.apppagamento.model.exceptions.ConsumoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.ImpostoInvalidoException;
import br.edu.infnet.apppagamento.model.exceptions.QuantidadeDeParcelasInvalidaException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "TConta")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conta implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private boolean contaAtiva;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@ManyToMany(mappedBy = "contas")
	private List<Pagamento> pagamentos;

	public Conta() {}
	public abstract boolean mostraContaAtiva() throws ConsumoInvalidoException, ImpostoInvalidoException, QuantidadeDeParcelasInvalidaException;

	public Conta(Integer id, String descricao, boolean contaAtiva) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.contaAtiva = contaAtiva;
	}

	@Override
	public String toString() {
		return "id: " + id + "\n" + "descrição: " + descricao + "\n" + "Conta Ativa? " + contaAtiva + "\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void impressao() {
		System.out.println("#Conta");
		System.out.println(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}

}
