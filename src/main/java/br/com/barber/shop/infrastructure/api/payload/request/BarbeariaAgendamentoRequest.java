package br.com.barber.shop.infrastructure.api.payload.request;

public record BarbeariaAgendamentoRequest(
        String dia,
        String mes,
        String ano,
        String hora){
}
