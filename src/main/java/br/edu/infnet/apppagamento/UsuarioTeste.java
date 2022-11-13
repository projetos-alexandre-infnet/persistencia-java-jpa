package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
@Order(1)
public class UsuarioTeste implements ApplicationRunner{

	private UsuarioService service;

	private Usuario usuario;

	public UsuarioTeste(UsuarioService service) {
		this.service = service;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		usuario = new Usuario();
		usuario.setEmail("admin@admin.com");
		usuario.setNome("Administrador");
		usuario.setSenha("123");
		
		service.incluir(usuario);
		
		String dir = "src/main/resources/files/";
		String arq = "usuarios.txt";
	
		try {
			try {
		
			FileReader fileReader = new FileReader(dir+arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			
			while(linha != null) {
				
					String[] campos = linha.split(";");
					usuario = new Usuario();
					usuario.setEmail(campos[0]);
					usuario.setNome(campos[1]);
					usuario.setSenha(campos[2]);
					
					service.incluir(usuario);
					linha = leitura.readLine();
			}
			
			leitura.close();
			fileReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("[ERRO] O arquivo não existe!!!");

			} catch (IOException e) {
				System.out.println("[ERRO] Problema no fechamento do arquivo!!!");
			}
		} finally {
			System.out.println("Terminou!!!");
		}

	}

}
