package br.com.petz.clientepet.pet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

	
		
}
	
	