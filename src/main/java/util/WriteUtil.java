package util;

import java.io.FileWriter;
import java.io.IOException;

public class WriteUtil {
	
	public static void escreveEQuebraLinha(FileWriter fileWriter, String conteudo) throws IOException {
		fileWriter.write(conteudo);
		fileWriter.write(System.getProperty("line.separator"));
	}

}
