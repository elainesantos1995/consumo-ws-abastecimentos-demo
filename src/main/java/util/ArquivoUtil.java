package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArquivoUtil {
	
	public static final String USER_DIR = System.getProperty("user.dir");
	
	public static Path criarDiretorioNaRaiz(String nomePasta) throws IOException {
		
		final Path DIRECTORY = Paths.get(ArquivoUtil.USER_DIR + "/" + nomePasta);
		
		if(Files.notExists(DIRECTORY)) {
			Files.createDirectories(DIRECTORY);
		}
		
		return DIRECTORY;
	
	}
	
	public static boolean criarArquivo(String caminhoArquivo) throws IOException {
		
		File arquivo = new File(caminhoArquivo);
		
		if(arquivo.createNewFile()) {
			System.out.println("Criado arquivo "+ arquivo.getName() + "!");
			return true;
		}else {
			System.out.println("Arquivo "+ arquivo.getName() + " já existe!");
			return false;
		}
	}
	
	public static void escreverEQuebrarLinha(FileWriter fileWriter, String conteudo) throws IOException {
		fileWriter.write(conteudo);
		fileWriter.write(System.getProperty("line.separator"));
	}

}
