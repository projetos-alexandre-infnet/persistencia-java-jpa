package br.edu.infnet.apppagamento;

import br.edu.infnet.apppagamento.model.domain.Tributo;
import br.edu.infnet.apppagamento.model.service.TributoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

@Component
@Order(5)
public class TributoTeste implements ApplicationRunner {

	private TributoService service;

	public TributoTeste(TributoService service) {
		this.service = service;
	}

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("# Tributo #");
		System.out.println("\n");

		String dir = "src/main/resources/files/";
		String arq = "conta.txt";

		try {
			try {
				FileReader fileReader = new FileReader(dir + arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				String linha = leitura.readLine();
					while (linha != null) {
						String[] campos = linha.split(";");
						if ("T".equalsIgnoreCase(campos[0])) {
							Tributo tributo = new Tributo();

							tributo.setICMS(BigDecimal.valueOf(Double.parseDouble(campos[1])));
							tributo.setIOF(BigDecimal.valueOf(Double.parseDouble(campos[2])));
							tributo.setISS(BigDecimal.valueOf(Double.parseDouble(campos[3])));
							tributo.setDescricao(campos[4]);
							service.incluir(tributo);
						}
						linha = leitura.readLine();
					}
					leitura.close();
					fileReader.close();
			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		} finally {
			System.out.println("TERMINOU!!!");
		}

	}

}
