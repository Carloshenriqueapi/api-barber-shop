package br.com.barber.shop.infrastructure.api.payload.request;

public record BarbeariaEnderecoRequest(
        Long id,
        String rua,
        String bairro,
        String cidade,
        String cep,
        String estado) {

}
