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
public class Tanque {

	private String codigo;
	private String nome;
	
	public String getNomeReport() {
		StringBuilder sb = new StringBuilder();
		
		int tamanho = this.nome.length();
		String nomeTruncado = this.nome.substring(0, Math.min(tamanho, 30));
		
		String nomePreenchido = ReportUtil.getFilledChars(' ', 30 - nomeTruncado.length());
		return sb.append(nomePreenchido).append(nomeTruncado).toString();
	}
	
	public String getCodigoReport() {
		StringBuilder sb = new StringBuilder();
		
		int tamanho = this.codigo.length();
		
		String volumePreenchido = ReportUtil.getFilledChars(' ', 49 - 6 - tamanho);
		return sb.append(volumePreenchido).append(this.codigo).toString();
	}
}
