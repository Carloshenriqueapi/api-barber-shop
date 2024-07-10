package br.com.barber.shop.infrastructure.api.payload.response;

public record BarbeariaAgendamentoResponse(
        Long id,
        Long agendaId,
        Long clienteId,
        String nomeAgenda,
        String nomeCliente){

}



