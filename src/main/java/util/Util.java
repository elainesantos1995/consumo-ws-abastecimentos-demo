package util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Util {
	
	public static String formatarVolumeAbastecido(float valor) {		
		DecimalFormat numeroFormatado = new DecimalFormat("##.###");
		String retorno = numeroFormatado.format(valor);
		return retorno;
	}
	
	public static boolean validarPlaca(String placa) {	
		String regex = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}";
  
		if (placa.matches(regex)) 
			return (placa.matches(regex));
		return false;
	    
	}
	
	public static String formatarPlaca(String placa) {	
		String[] nova = placa.split("-");
		return nova[0]+nova[1];		    
	}
    
	public static String dataFormatada(String dt) {

		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = formatter.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dataFormatada = dateFormat.format(date);
        
        return ""+dataFormatada;	
	}

	public static String cnpjFormatado(String cnpj) {
		
		String x = cnpj.replaceAll(Pattern.quote("."), ""); 
		String y = x.replaceAll(Pattern.quote("/"), ""); 
		String z = y.replaceAll(Pattern.quote("-"), ""); 
		return z;
	}

	public static String preencherEspacos(String palavra, int tamanho) {
		int tamanhoPalavra = palavra.length();
		String resultado = "";
		if(tamanho == tamanhoPalavra) {
			return palavra;
		}else {
			for(int i = tamanhoPalavra; i < tamanho; i++) {
				resultado += " ";
			}
			return resultado += palavra;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(validarPlaca("AAA9999"));
		System.out.println(formatarVolumeAbastecido(10.326665f));
		System.out.println(dataFormatada("19/06/1995"));
		System.out.println(formatarPlaca("AAA-9999"));
		System.out.println(cnpjFormatado("47.960.950/0001-21"));
		System.out.println(preencherEspacos("Maria Elaine", 20));
		System.out.println(preencherEspacos("Maria", 20));
	
	}
	
	
}
