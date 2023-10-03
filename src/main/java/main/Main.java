package main;

import java.io.IOException;

import servico.RelatorioService;

public class Main {	
	
	/**
	 * Arquivos .txt estão sendo gerados na pasta "data"
	 * 
	 * **/

	public static void main(String[] args) throws IOException {
		RelatorioService.gerarRelatorioComIntervaloDeDatas("01/01/2021", "15/02/2021");
	}

}
