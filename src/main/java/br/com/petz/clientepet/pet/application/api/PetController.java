package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.pet.application.service.PetService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {
    private final PetService petService;

    @Override
    public PetResponse postPet(UUID idCliente, PetRequest petRequest) {
        log.info("[start] PetController - postPet");
        log.info("[IdCliente] {}", idCliente);
        PetResponse pet = petService.criaPet(idCliente, petRequest);
        log.info("[finish] PetController - postPet");
        return pet;
    }

    @Override
    public List<PetClienteListResponse> getPetsDoClienteComId(UUID idCliente) {
        log.info("[start] PetController - getPetsDoClienteComId");
        log.info("[IdCliente] {}", idCliente);
        List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoClienteComId(idCliente);
        log.info("[finish] PetController - getPetsDoClienteComId");
        return petsDoCliente;
    }

    

	@Override
	public PetClienteDetalheResponse getPetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[start] PetController - getPetDoClienteComId");
        log.info("[IdCliente] {} - [idPet] {}", idCliente, idPet);
        PetClienteDetalheResponse pet = petService.buscaPetDoClienteComId(idCliente, idPet);
        log.info("[start] PetController - getPetDoClienteComId");
        return pet;
		
	}

	@Override
	public void deletePetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[start] PetController - deletePetDoClienteComId");
		log.info("[IdCliente] {} - [idPet] {}", idCliente, idPet);
		petService.deletaPetDoClienteComId(idCliente, idPet);
		log.info("[start] PetController - deletePetDoClienteComId");
		
		
		
	}

	@Override
	public void patchPet(UUID idCliente, UUID idPet, @Valid PetAlteracaoRequest petAlteracaoRequest) {
		log.info("[start] PetController - patchPet");
		log.info("[IdCliente] {} - [idPet] {}", idCliente, idPet);
		petService.alteraPetDoClienteComId(idCliente, idPet, petAlteracaoRequest);
		log.info("[finish] PetController - patchPet");
		
	
	}
}

