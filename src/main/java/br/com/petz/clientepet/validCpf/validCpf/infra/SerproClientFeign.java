package br.com.petz.clientepet.validCpf.validCpf.infra;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "serproClientFeing", url = "https://gateway.apiserpro.serpro.gov.br/consulta-cpf-df-trial")
public interface SerproClientFeign {
    @GetMapping(value = "/v1/cpf/{cpf}")
    ConsultaCpfResponse consultaCPF(@RequestHeader(value = "Authorization") String authorization,
                                    @PathVariable String cpf);
}
