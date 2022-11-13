package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Extra;
import br.edu.infnet.apppagamento.model.service.ExtraService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
@Order(4)
public class ExtraTeste implements ApplicationRunner {

	private ExtraService service;

	public ExtraTeste(ExtraService service) {
		this.service = service;
	}

	@Override
	public void run(ApplicationArguments args)  {

		System.out.println("# Extra #");
		System.out.println("\n");

		String dir = "src/main/resources/files/";
		String arq = "conta.txt";

		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
					while (linha != null) {
						String[] campos = linha.split(";");
						if ("E".equalsIgnoreCase(campos[0])) {
						Extra extra = new Extra();
						extra.setNumeroDeParcelas(Integer.valueOf(campos[1]));
						extra.setPagamentoLote(Boolean.parseBoolean(campos[2]));
						extra.setPagamentoUnico(Boolean.parseBoolean(campos[3]));
						extra.setDescricao(campos[4]);
						service.incluir(extra);
					}

					linha = leitura.readLine();
				}
				leitura.close();
				fileReader.close();
			} catch (IOException e) {
				System.out.println("ERROR: "+e.getMessage());
			}
		} finally {
			System.out.println("TERMINOU!!!");
		}

	}

}
