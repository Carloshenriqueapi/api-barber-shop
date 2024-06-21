package br.com.barber.shop.infrastructure.api.payload.response;

public record BarbeariaEnderecoResponse(
        String rua,
        String bairro,
        String cidade,
        String cep,
        String estado) {

}
