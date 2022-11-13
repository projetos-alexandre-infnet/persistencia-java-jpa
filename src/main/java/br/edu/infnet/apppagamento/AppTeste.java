package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.app.Atributo;
import br.edu.infnet.apppagamento.model.domain.app.Classe;
import br.edu.infnet.apppagamento.model.domain.app.Projeto;
import br.edu.infnet.apppagamento.model.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AppTeste implements ApplicationRunner{

	private AppService appService;

	public AppTeste(AppService appService) {
		this.appService = appService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		String dir = "src/main/resources/files/";
		String arq = "app.txt";
	
		try {
			try {
		
			FileReader fileReader = new FileReader(dir+arq);
			BufferedReader leitura = new BufferedReader(fileReader);
			String linha = leitura.readLine();
			Projeto projeto = null;
			List<Classe> classes = null;
			List<Atributo> atributos = null;
			
			while(linha != null) {
				
				String[] campos = linha.split(";");
				switch (campos[0].toUpperCase()) {
					case "P" -> {
						classes = new ArrayList<>();
						projeto = new Projeto();
						projeto.setNome(campos[1]);
						projeto.setDescricaoProjeto(campos[2]);
						projeto.setClasses(classes);
					}
					case "C" -> {
						atributos = new ArrayList<>();
						Classe classe = new Classe();
						classe.setNome(campos[1]);
						classe.setAtributos(atributos);
						classes.add(classe);
					}

					case "A" -> {
						Atributo atributo = new Atributo(campos[1], campos[2], campos[3]);
						atributos.add(atributo);
					}
					default -> System.out.println("Opção inválida");
				}

				linha = leitura.readLine();
			}
			appService.incluir(projeto);

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
