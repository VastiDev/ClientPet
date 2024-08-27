package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.petz.clientepet.pet.domain.Pet;
import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.SexoPet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import lombok.Value;
@Value
public class PetClienteDetalheResponse {
	
	private UUID idPet;
	private String nomePet;
	private Porte porte;
	private TipoPet tipo;
	private String microchip;
	private String raça;
	private SexoPet sexo;
	private String pelagemCor;
	private String rga;
	private LocalDate dataNascimento;
	private Integer peso;

	public PetClienteDetalheResponse(Pet pet) {
		this.idPet = pet.getIdPet();
		this.nomePet = pet.getNomePet();
		this.porte = pet.getPorte();
		this.tipo = pet.getTipo();
		this.microchip = pet.getMicrochip();
		this.raça = pet.getRaça();
		this.sexo = pet.getSexo();
		this.pelagemCor = pet.getPelagemCor();
		this.rga = pet.getRga();
		this.dataNascimento = pet.getDataNascimento();
		this.peso = pet.getPeso();
		
	}
}