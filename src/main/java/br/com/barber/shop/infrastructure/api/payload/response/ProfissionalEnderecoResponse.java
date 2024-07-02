package br.com.barber.shop.infrastructure.api.payload.response;

import lombok.Builder;

@Builder
public record ProfissionalEnderecoResponse(

        String rua,
        String bairro,
        String cidade,
        String cep,
        String numeroResidencia,
        String uf){

}
