package servico;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import dominio.Abastecimento;
import dominio.CTAPlus;
import net.APIConnection;
import util.ArquivoUtil;
import util.DataUtil;
import util.ManipuladorDeJson;
	
public class RelatorioService {
	
	private static final String FILE_NAME = "_Abastecimencimentos";

	public static void gerarRelatorioComIntervaloDeDatas(String dataInicial, String dataFinal) throws IOException {

		HttpURLConnection conn = APIConnection.connect(dataInicial, dataFinal);
	
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		CTAPlus ctaPlus = ManipuladorDeJson.entradaDeJsonParaObject(br, CTAPlus.class);
	
		final Path DIRECTORY = ArquivoUtil.criarDiretorioNaRaiz("data");
	
		LocalDate startDate = LocalDate.parse(dataInicial, DataUtil.DATE_FORMATER);
		LocalDate endDate = LocalDate.parse(dataFinal, DataUtil.DATE_FORMATER);
	
		int countAbastecimentos = 0;
		for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
		String actualDate = date.format(DataUtil.DATE_FORMATER);

		if(ctaPlus.getAbastecimentos() != null && !ctaPlus.getAbastecimentos().isEmpty()) {
			
			System.out.println(actualDate);
			System.out.println(ctaPlus);
			List<Abastecimento> abastecimentos = ctaPlus.getAbastecimentos().stream()
			.filter(a -> a.getDataInicio().equals(actualDate)).collect(Collectors.toList());
		
			if(countAbastecimentos >= 100)
				return;
		
			String filePath = DIRECTORY.toString() + "/" + getNomeArquivo(date.toString(), "txt");
			if(!ArquivoUtil.criarArquivo(filePath)) return;
		
			FileWriter writer = new FileWriter(filePath);
		
			for (Abastecimento abastecimento : abastecimentos) {
				String line = abastecimento.getAbastecimentoRelatorio();
				ArquivoUtil.escreverEQuebrarLinha(writer, line);
			
				countAbastecimentos++;
			}
		
			writer.close();
		
			}
		}	

	}
	
	private static String getNomeArquivo(String data, String extensao) {
		return data + RelatorioService.FILE_NAME + "." + extensao;
	}
	
}
