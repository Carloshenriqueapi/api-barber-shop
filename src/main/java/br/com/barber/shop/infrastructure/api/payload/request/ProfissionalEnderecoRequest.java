package br.com.barber.shop.infrastructure.api.payload.request;

public record ProfissionalEnderecoRequest(
        String rua,
        String bairro,
        String cidade,
        String cep,
        String numeroResidencia,
        String uf){
}
