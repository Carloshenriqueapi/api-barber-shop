package br.com.barber.shop.infrastructure.converter;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendamentoRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendamentoResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgendamento;
import br.com.barber.shop.infrastructure.database.entity.Cliente;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaAgendaRepository;
import br.com.barber.shop.infrastructure.database.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BarbeariaAgendamentoConverter {

    private final BarbeariaAgendaRepository agendaRepository;
    private final ClienteRepository clienteRepository;

    public BarbeariaAgendamentoConverter(BarbeariaAgendaRepository agendaRepository, ClienteRepository clienteRepository) {
        this.agendaRepository = agendaRepository;
        this.clienteRepository = clienteRepository;
    }

    public BarbeariaAgendamento apply(BarbeariaAgendamentoRequest barbeariaAgendamentoRequest) {
        if (barbeariaAgendamentoRequest == null) {
            return null;
        }

        BarbeariaAgenda agenda = agendaRepository.findById(barbeariaAgendamentoRequest.agendaId())
                .orElseThrow(() -> new RuntimeException("Agenda não Encontrada"));


        Cliente cliente = clienteRepository.findById(barbeariaAgendamentoRequest.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não Encontrado"));

        BarbeariaAgendamento agendamento = new BarbeariaAgendamento();
        agendamento.setAgenda(agenda);
        agendamento.setCliente(cliente);
        return agendamento;
    }

    public List<BarbeariaAgendamentoResponse> applyResponse(List<BarbeariaAgendamento> all) {
        if (all != null && !all.isEmpty()) {
            return all.stream()
                    .map(this::applyResponse)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public BarbeariaAgendamentoResponse applyResponse(BarbeariaAgendamento barbeariaAgendamento) {
        if (barbeariaAgendamento == null) {
            return null;
        }

        BarbeariaAgenda agenda = barbeariaAgendamento.getAgenda();
        Cliente cliente = barbeariaAgendamento.getCliente();

        return new BarbeariaAgendamentoResponse(
                barbeariaAgendamento.getId(),
                agenda != null ? agenda.getId() : null,
                cliente != null ? cliente.getId() : null,
                agenda != null ? agenda.getNome() : null,
                cliente != null ? cliente.getNome() : null
        );
    }
}




