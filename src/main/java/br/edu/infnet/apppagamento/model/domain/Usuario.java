package br.edu.infnet.apppagamento.model.domain;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TUsuario")
public class Usuario implements IPrinter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;

	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Cliente> clientes;

	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Pagamento> produtos;

	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Conta> contas;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}



	public String getSenha() {
		return senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public void impressao() {
		System.out.println("#usuario");
		System.out.println(this);
		
	}
	

}
