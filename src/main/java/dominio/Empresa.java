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
public class Empresa {
	
	private String cnpj;
	private String nome;
	
	public String getNomeReport() {
		StringBuilder sb = new StringBuilder();
		
		int tamanho = this.nome.length();
		String nomeTruncado = this.nome.substring(0, Math.min(tamanho, 49));
		
		String nomePreenchido = ReportUtil.getFilledChars(' ', 49 - nomeTruncado.length());
		return sb.append(nomePreenchido).append(nomeTruncado).toString();
	}
}
