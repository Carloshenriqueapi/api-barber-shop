package br.com.barber.shop.infrastructure.converter;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendamentoRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendamentoResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgendamento;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BarbeariaAgendamentoConverter {

    public BarbeariaAgendamento apply(BarbeariaAgendamentoRequest barbeariaAgendamentoRequest) {
        if (barbeariaAgendamentoRequest == null) {
            return null;
        }

        return BarbeariaAgendamento.builder()
                .dia(barbeariaAgendamentoRequest.dia())
                .hora(barbeariaAgendamentoRequest.hora())
                .mes(barbeariaAgendamentoRequest.mes())
                .ano(barbeariaAgendamentoRequest.ano())
                .build();
    }

    public List<BarbeariaAgendamentoResponse> applyResponse(List<BarbeariaAgendamento> all) {
        if (all != null && !all.isEmpty()) {
            return all.stream()
                    .map(agendamento -> new BarbeariaAgendamentoResponse(
                            agendamento.getDia(),
                            agendamento.getHora(),
                            agendamento.getMes(),
                            agendamento.getAno()
                    )).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public BarbeariaAgendamentoResponse applyResponse(BarbeariaAgendamento barbeariaAgendamento) {
        return new BarbeariaAgendamentoResponse(
                barbeariaAgendamento.getDia(),
                barbeariaAgendamento.getHora(),
                barbeariaAgendamento.getMes(),
                barbeariaAgendamento.getAno());
    }
}

