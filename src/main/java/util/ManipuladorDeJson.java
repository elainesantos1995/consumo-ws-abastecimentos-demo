package util;

import java.io.BufferedReader;

import com.google.gson.Gson;

public class ManipuladorDeJson {
	
	public static <T> T entradaDeJsonParaObject(BufferedReader bufferedReader, Class<T> classe) {		
		Gson gson = new Gson();
		return gson.fromJson(bufferedReader, classe);		
	}

	public static <T> T  entradaDeJsonParaObject(String jsonString, Class<T> classe) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, classe);
	}
}
