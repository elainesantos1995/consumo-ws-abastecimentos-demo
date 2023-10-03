package dominio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.ReportUtil;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Posto {
	
	private String nome;
	private String cnpj;
	
	public String getNomeReport() {
		StringBuilder sb = new StringBuilder();
		
		int tamanho = this.nome.length();
		String nomeTruncado = this.nome.substring(0, Math.min(tamanho, 30));
		
		String nomePreenchido = ReportUtil.getFilledChars(' ', 30 - nomeTruncado.length());
		return sb.append(nomePreenchido).append(nomeTruncado).toString();
	}

}
