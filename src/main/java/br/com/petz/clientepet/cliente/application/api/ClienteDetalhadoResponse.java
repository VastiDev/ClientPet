package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.domain.Sexo;
import br.com.petz.clientepet.endereco.api.EnderecoResponse;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String email;
    private String celular;
    private String cpf;
    private Sexo sexo;
    private EnderecoResponse endereco;
    private LocalDateTime dataHoraDoCadastro;
    private Boolean aceitaTermos;

    public ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
        this.cpf = cliente.getCpf();
        this.sexo = cliente.getSexo();
        this.endereco = new EnderecoResponse(
                cliente.getEndereco().getCep(),
                cliente.getEndereco().getLogradouro(),
                cliente.getEndereco().getComplemento(),
                cliente.getEndereco().getBairro(),
                cliente.getEndereco().getCidade(),
                cliente.getEndereco().getUf()
        );
        this.dataHoraDoCadastro = cliente.getDataHoraDoCadastro();
        this.aceitaTermos = cliente.getAceitaTermos();

    }

}