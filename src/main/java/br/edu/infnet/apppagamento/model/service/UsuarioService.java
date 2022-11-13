package br.edu.infnet.apppagamento.model.service;

import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.persistence.UsuarioDAO;
import br.edu.infnet.apppagamento.model.test.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {

	private UsuarioDAO usuarioDAO;

	public UsuarioService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	private static Map<String, Usuario> mapaUsuario = new HashMap<>();
	
	public Usuario validar(String email, String senha) {

		Usuario u = mapaUsuario.get(email);

		if(senha.equals(u.getSenha())) {
			return u;
		}

		return null;
	}
	
	
	public void incluir(Usuario usuario) {
		usuarioDAO.save(usuario);

		mapaUsuario.put(usuario.getEmail(), usuario);
		AppImpressao.relatorio("Usuario: ", usuario);
	}
	
	public void excluir(String email) {
		mapaUsuario.remove(email);
	}
	
	
	public Collection<Usuario> obterLista() {
		return mapaUsuario.values();
	}

}
