package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.endereco.api.EnderecoResponse;
import br.com.petz.clientepet.endereco.api.ViaCepClient;
import br.com.petz.clientepet.endereco.domain.Endereco;
import br.com.petz.clientepet.endereco.service.EnderecoService;
import br.com.petz.clientepet.validCpf.applicationservice.ValidCpfApplicationService;
import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteraRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
	private final ClienteRepository clienteRepository;
	private final ValidCpfApplicationService validCpfApplicationService;
	private final EnderecoService enderecoService;
	private final ViaCepClient viaCepClient; // Injete o ViaCepClient


	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia]ClienteApplicationService - criaCliente");
		validCpfApplicationService.validaCpfdoCliente(clienteRequest.getCpf());

		Cliente cliente = new Cliente(clienteRequest);
		// Supondo que clienteRequest tenha um campo para CEP
		Endereco endereco = enderecoService.buscaEnderecoPorCep(clienteRequest.getCep());
		if (endereco != null) {
			cliente.setEndereco(endereco);
			// Aqui você pode salvar o cliente e o endereço no banco de dados
		}

		Cliente clienteSalvo = clienteRepository.salva(cliente);
		log.info("[finaliza]ClienteApplicationService - criaCliente");
		return ClienteResponse.builder()
				.idCliente(clienteSalvo.getIdCliente())
				.build();
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia]ClienteApplicationService - buscaTodosClientes");
		List<Cliente> clientes = clienteRepository.buscaTodosClientes();
		log.info("[finaliza]ClienteApplicationService - buscaTodosClientes");		
		return ClienteListResponse.converte(clientes);
	}
	@Override
	public ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente) {
		log.info("[inicia]ClienteApplicationService - buscaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		log.info("[finaliza]ClienteApplicationService - buscaClienteAtravesId");
		
		return new ClienteDetalhadoResponse(cliente);
	}
	@Override
	public void deletaClienteAtravesId(UUID idCliente) {
		log.info("[inicia]ClienteApplicationService - deletaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		clienteRepository.deletaCliente(cliente);
		log.info("[finaliza]ClienteApplicationService - deletaClienteAtravesId");
		
	}
	@Override
	public void patchAlteraCliente(UUID idCliente, ClienteAlteraRequest clienteAlteraRequest) {
		log.info("[inicia]ClienteApplicationService - patchAlteraCliente");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		cliente.altera(clienteAlteraRequest);
		clienteRepository.salva(cliente);
		log.info("[finaliza]ClienteApplicationService - patchAlteraCliente");
		
	}

}
