package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Cliente;
import br.edu.infnet.apppagamento.model.domain.Usuario;
import br.edu.infnet.apppagamento.model.exceptions.CpfOuCnpjInvalidoException;
import br.edu.infnet.apppagamento.model.service.ClienteService;
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
@Order(2)
public class ClienteTeste implements ApplicationRunner {

	private ClienteService service;

	public ClienteTeste(ClienteService service) {
		this.service = service;
	}

	@Override
	public void run(ApplicationArguments args) {
		Usuario usuario = new Usuario();
		usuario.setId(1);

		System.out.println("# Cliente #");
		System.out.println("\n");

		String dir = "src/main/resources/files/";
		String arq = "cliente.txt";

		try {
			try {

				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();

				while(linha != null) {

					String[] campos = linha.split(";");

					try {
						Cliente cliente = new Cliente(Integer.valueOf(campos[0]), campos[1],campos[2],campos[3]);
						cliente.setUsuario(usuario);
						service.incluir(cliente);
					} catch (CpfOuCnpjInvalidoException e) {
						System.out.println("[ERROR] " + e.getMessage());
					}
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
