package dominio;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class CTAPlus {
	
	@Getter	@Setter
	public List<Abastecimento> abastecimentos;
	@Getter	@Setter
	private Status status;

}
