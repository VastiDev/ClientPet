package br.com.petz.clientepet.pet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetAlteracaoRequest;
import br.com.petz.clientepet.pet.application.api.PetRequest;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity

public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idPet", updatable = false, unique = true, nullable = false)
	private UUID idPet;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idClienteTutor", nullable = false)
	private UUID idClienteTutor;
	@NotBlank
	private String nomePet;
	@Enumerated(EnumType.STRING)
	private Porte porte;
	@Enumerated(EnumType.STRING)
	private TipoPet tipo;
	private String microchip;
	private String raça;
	@Enumerated(EnumType.STRING)
	private SexoPet sexo;
	private String pelagemCor;
	private String rga;
	@NotNull
	private LocalDate dataNascimento;
	private Integer peso;
		
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public Pet(UUID idCliente, @Valid PetRequest petRequest) {
		this.idClienteTutor = idCliente;
		this.nomePet = petRequest.getNomePet();
		this.porte = petRequest.getPorte();
		this.tipo = petRequest.getTipo();
		this.microchip = petRequest.getMicrochip();
		this.raça = petRequest.getRaça();
		this.sexo = petRequest.getSexo();
		this.pelagemCor = petRequest.getPelagemCor();
		this.rga = petRequest.getRga();
		this.dataNascimento = petRequest.getDataNascimento();
		this.peso = petRequest.getPeso();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public Pet() {

	}

	public void altera(PetAlteracaoRequest petAlteracaoRequest) {
		this.nomePet = petAlteracaoRequest.getNomePet();
		this.porte = petAlteracaoRequest.getPorte();
		this.tipo = petAlteracaoRequest.getTipo();
		this.microchip = petAlteracaoRequest.getMicrochip();
		this.raça = petAlteracaoRequest.getRaça();
		this.sexo = petAlteracaoRequest.getSexo();
		this.pelagemCor = petAlteracaoRequest.getPelagemCor();
		this.rga = petAlteracaoRequest.getRga();
		this.dataNascimento = petAlteracaoRequest.getDataNascimento();
		this.peso = petAlteracaoRequest.getPeso();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
		
		
	}

	
		
}
	
	