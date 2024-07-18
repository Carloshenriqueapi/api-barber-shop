package br.com.barber.shop.infrastructure.api.payload.response;

public record BarbeariaAvaliacaoResponse (
        Long id,
        Long clienteId,
        Long servicoId,
        int estrelas,
        String texto){
}
