package br.com.petz.clientepet.endereco.service;

import br.com.petz.clientepet.endereco.api.EnderecoResponse;
import br.com.petz.clientepet.endereco.api.ViaCepClient;
import br.com.petz.clientepet.endereco.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private final ViaCepClient viaCepClient;

    @Autowired
    public EnderecoService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public Endereco buscaEnderecoPorCep(String cep) {
        EnderecoResponse enderecoResponse = viaCepClient.buscaEnderecoPorCep(cep);
        return converteParaEndereco(enderecoResponse);
    }

    public Endereco converteParaEndereco(EnderecoResponse enderecoResponse) {
        if (enderecoResponse == null) {
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setCep(enderecoResponse.getCep());
        endereco.setLogradouro(enderecoResponse.getLogradouro());
        endereco.setComplemento(enderecoResponse.getComplemento());
        endereco.setBairro(enderecoResponse.getBairro());
        endereco.setCidade(enderecoResponse.getLocalidade());
        endereco.setUf(enderecoResponse.getUf());
        // Se você tiver um identificador ou outras propriedades em Endereco, configure-as aqui conforme necessário
        return endereco;
    }
}

