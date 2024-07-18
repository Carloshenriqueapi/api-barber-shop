package br.com.barber.shop.infrastructure.api.payload.request;

public record BarbeariaAgendaRequest(
        Long agendaId,
        String dia,
        String mes,
        String ano,
        String hora,
        String status,
        Long profissionalId,
        Long servicoId){

}
