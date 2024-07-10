package br.com.barber.shop.infrastructure.api.payload.request;

public record BarbeariaAgendaRequest(
        String dia,
        String mes,
        String ano,
        String hora,
        Long profissionalId,
        Long servicoId
) {

}
