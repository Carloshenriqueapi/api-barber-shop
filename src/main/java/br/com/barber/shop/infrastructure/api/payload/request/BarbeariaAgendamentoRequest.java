package br.com.barber.shop.infrastructure.api.payload.request;

public record BarbeariaAgendamentoRequest(
        Long agendaId,
        Long clienteId
) {
    public Long getAgendaId() {
        return agendaId;
    }

    public Long getClienteId() {
        return clienteId;
    }
}


