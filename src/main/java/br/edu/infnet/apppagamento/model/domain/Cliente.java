package br.edu.infnet.apppagamento.model.domain;

import br.edu.infnet.apppagamento.model.exceptions.CpfOuCnpjInvalidoException;
import br.edu.infnet.apppagamento.interfaces.IPrinter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TCliente")
public class Cliente implements IPrinter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCpnj;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String email, String cpfOuCpnj) throws CpfOuCnpjInvalidoException {
		if(cpfOuCpnj == null) {
			throw new CpfOuCnpjInvalidoException("CPF ou CNPJ não pode ser nulo");
		}
		
		if (cpfOuCpnj.isEmpty()) {
			throw new CpfOuCnpjInvalidoException("CPF ou CNPJ não pode ser vazio");
		}
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCpnj = cpfOuCpnj;
	}

	@Override
	public String toString() {
		return "id do cliente: " + id + ", nome: " + nome + ", email: " + email + ", CPF ou CNPJ: " + cpfOuCpnj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCpnj() {
		return cpfOuCpnj;
	}

	public void setCpfOuCpnj(String cpfOuCpnj) {
		this.cpfOuCpnj = cpfOuCpnj;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public void impressao() {
		System.out.println("#cliente");
		System.out.println(this);
	}

}
