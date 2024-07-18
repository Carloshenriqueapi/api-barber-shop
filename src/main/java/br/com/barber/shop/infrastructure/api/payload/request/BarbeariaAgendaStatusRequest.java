package br.com.barber.shop.infrastructure.api.payload.request;

public record BarbeariaAgendaStatusRequest (
        Long agendaId,
        String status){
}
