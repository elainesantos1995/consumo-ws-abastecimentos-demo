package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReportUtil {

	public static String getFilledChars(char caractere, int tamanho) {
		char[] array = new char[tamanho];
		Arrays.fill(array, caractere);
		return String.valueOf(array);
	}
	
	public static long dateDiff(String dataInicial, String dataFinal) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date primeiraData, segundaData;
		
		try {
			primeiraData = formatador.parse(dataInicial);
			segundaData = formatador.parse(dataFinal);					
		}catch (ParseException e) {
			return 01;
		}
		
		long diffInMillies = Math.abs(segundaData.getTime() - primeiraData.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MICROSECONDS);
		
		return diff;
	}

}
