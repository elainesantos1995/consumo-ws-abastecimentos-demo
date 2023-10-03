package net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIConnection {
	
	private static final String BASE_URL = "https://dev.ctaplus.com.br:8443/SvWebSincronizaAbastecimentos";
	private static final String DEFAULT_TOKEN = "?token=y3lUAndNXr";
	private static final String FORMATO_JSON = "&formato=json";
	private static final String DATA_INICIAL = "&data_inicio=";
	private static final String DATA_FINAL	 = "&data_fim=";

	public static HttpURLConnection connect() throws IOException{
		return connect(null, null, null);
	}
	
	public static HttpURLConnection connect(String paramUrl) throws IOException{
		return connect(paramUrl, null, null);
	}
	
	public static HttpURLConnection connect(String dataInicial, String dataFinal) throws IOException{
		return connect(null, dataInicial, dataFinal);
	}
	
	public static HttpURLConnection connect(String paramUrl, String dataInicial, String dataFinal) throws IOException{
		
		paramUrl = paramUrl != null ? paramUrl: BASE_URL;
		dataInicial = dataInicial != null ? dataInicial : "01/01/2020";
		dataFinal = dataFinal != null ? dataFinal : "01/01/2020";
		
		URL url = new URL(paramUrl + DEFAULT_TOKEN + FORMATO_JSON + DATA_INICIAL + dataInicial + DATA_FINAL + dataFinal);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if(conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed! Http Error Code: "+ conn.getResponseCode());
		}
		
		return conn;
	}
}
