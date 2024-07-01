package br.com.barber.shop.infrastructure.converter;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendaRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendaResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BarbeariaAgendaConverter implements Function<BarbeariaAgendaRequest, BarbeariaAgenda> {
    @Override
    public BarbeariaAgenda apply(BarbeariaAgendaRequest barbeariaAgendaRequest) {
        if (barbeariaAgendaRequest == null) {
            return null;
        }

        return BarbeariaAgenda.builder()
                .dia(barbeariaAgendaRequest.dia())
                .hora(barbeariaAgendaRequest.hora())
                .mes(barbeariaAgendaRequest.mes())
                .ano(barbeariaAgendaRequest.ano())
                .build();
    }

    public List<BarbeariaAgendaResponse> applyResponse(List<BarbeariaAgenda> all) {
        if (all != null && !all.isEmpty()) {
            return all.stream()
                    .map(agenda -> new BarbeariaAgendaResponse(
                            agenda.getDia(),
                            agenda.getHora(),
                            agenda.getMes(),
                            agenda.getAno()
                    )).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public BarbeariaAgendaResponse applyResponse(BarbeariaAgenda barbeariaAgenda) {
        return new BarbeariaAgendaResponse(
                barbeariaAgenda.getDia(),
                barbeariaAgenda.getHora(),
                barbeariaAgenda.getMes(),
                barbeariaAgenda.getAno());
    }
}