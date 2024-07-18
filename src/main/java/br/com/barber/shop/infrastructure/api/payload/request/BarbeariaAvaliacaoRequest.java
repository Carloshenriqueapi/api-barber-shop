package br.com.barber.shop.infrastructure.api.payload.request;

public record BarbeariaAvaliacaoRequest (
        Long clienteId,
        Long servicoId,
        int estrelas,
        String texto){
}
