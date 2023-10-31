package br.com.petz.clientepet.cliente.application.api;

import java.time.LocalDate;
import br.com.petz.clientepet.cliente.domain.Sexo;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ClienteAlteraRequest {
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Boolean aceitaTermos;
}
