package br.com.petz.clientepet.validCpf.applicationservice;

import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.validCpf.validCpf.infra.ConsultaCpfResponse;
import br.com.petz.clientepet.validCpf.validCpf.infra.SerproClientFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ValidCpfApplicationService implements ValidCpfService {
    private final SerproClientFeign serproClientFeign;

    @Override
    public void validaCpfdoCliente(String cpf) {
        log.info("[start] AssociadoApplicationService - validaAssociadoAptoVoto");
        ConsultaCpfResponse consultaCPFResponse = serproClientFeign.consultaCPF(TOKEN,cpf);
        valida(consultaCPFResponse);
        log.info("[finish] AssociadoApplicationService - validaAssociadoAptoVoto");
    }

    private void valida(ConsultaCpfResponse consultaCPFResponse) {
        if(consultaCPFResponse.isInvalid()) {
            throw APIException.build(HttpStatus.OK,"CPF inválido!");
        }
    }

    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";

}


