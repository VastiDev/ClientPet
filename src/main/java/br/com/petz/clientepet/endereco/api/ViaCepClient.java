package br.com.petz.clientepet.endereco.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViaCepClient {
    @GetMapping("/{cep}/json/")
    EnderecoResponse buscaEnderecoPorCep(@PathVariable("cep") String cep);
}
