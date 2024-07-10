package br.com.barber.shop.infrastructure.api.payload.response;

public record BarbeariaAgendaResponse (

        Long id,
        String dia,
        String hora,
        String mes,
        String ano,
        Long profissionalId,
        Long servicoId){



}





