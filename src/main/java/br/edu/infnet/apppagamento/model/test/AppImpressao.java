package br.edu.infnet.apppagamento.model.test;

import br.edu.infnet.apppagamento.interfaces.IPrinter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppImpressao {
	public static void relatorio(String mensagem, IPrinter printer) {
		System.out.println(mensagem);
		printer.impressao();
	}
	
	public static void main(String[] args) {
		String dir = "/home/alexandre/";
		String arq = "file.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				
				String linha = leitura.readLine();
				while(linha != null) {
					System.out.println(linha);
					linha = leitura.readLine();
				}
				leitura.close();
				fileReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: "+e.getMessage());
			} catch(IOException e) {
				System.out.println("ERROR: "+e.getMessage());
			}
			
		} finally {
			System.out.println("TERMINOU!");
		}
	}
}
