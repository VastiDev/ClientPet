package br.com.petz.clientepet.cliente.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteraRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;

import lombok.NoArgsConstructor;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idCliente", updatable = false, unique = true, nullable = false)
	private UUID idCliente;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@CPF
	@Column(unique = true)
	private String cpf;
	
	@NotNull
	private Boolean aceitaTermos;
		
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public Cliente(ClienteRequest clienteRequest) {
		this.nomeCompleto = clienteRequest.getNomeCompleto();
		this.email = clienteRequest.getEmail();
		this.celular = clienteRequest.getCelular();
		this.telefone = clienteRequest.getTelefone();
		this.sexo = clienteRequest.getSexo();
		this.dataNascimento = clienteRequest.getDataNascimento();
		this.cpf = clienteRequest.getCpf();
		this.aceitaTermos = clienteRequest.getAceitaTermos();
		this.dataHoraDoCadastro = LocalDateTime.now();
	
	}

	public void altera(ClienteAlteraRequest clienteAlteraRequest) {
		this.nomeCompleto = clienteAlteraRequest.getNomeCompleto();
		this.celular = clienteAlteraRequest.getCelular();
		this.telefone = clienteAlteraRequest.getTelefone();
		this.sexo = clienteAlteraRequest.getSexo();
		this.dataNascimento = clienteAlteraRequest.getDataNascimento();
		this.aceitaTermos = clienteAlteraRequest.getAceitaTermos();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
		
		
	}
		
}

	