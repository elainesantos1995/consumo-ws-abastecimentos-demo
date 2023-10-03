package dominio;

import java.util.Locale;

import com.google.gson.annotations.SerializedName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.ReportUtil;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Abastecimento {
	
	@SerializedName(value = "data_inicio")
	private String dataInicio;
	@SerializedName(value = "hora_inicio")
	private String horaInicio;
	private String volume;
	private Veiculo veiculo;
	private Posto posto;
	private Tanque tanque;
	private Bomba bomba;
	private Empresa empresa;
	
	public String getVolumeReport() {
		StringBuilder sb = new StringBuilder();
		
		Float volumeFloat = Float.parseFloat(this.volume.replace(',', '.'));
		String volumeFormatado = String.format(Locale.US, "%.3f", volumeFloat);
		int tamanho = volumeFormatado.length() > 9 ? 9 : volumeFormatado.length();
		String volumeFormtadoFinal = ReportUtil.getFilledChars('0', 9 - tamanho);
		
		return sb.append(volumeFormtadoFinal).append(volumeFormatado).toString();		
	}
	
	public String getAbastecimentoRelatorio() {
		return 
				this.getDataInicio() +
				this.getVeiculo().getPlaca() + 
				this.getVolumeReport() + 
				this.getEmpresa().getCnpj() +
				this.getEmpresa().getNomeReport()+
				this.getPosto().getNomeReport() + 
				this.getTanque().getCodigoReport() + 
				this.getTanque().getNomeReport() + 
				this.getBomba().getCodigoReport() + 
				this.getBomba().getNomeReport();
	}

}
