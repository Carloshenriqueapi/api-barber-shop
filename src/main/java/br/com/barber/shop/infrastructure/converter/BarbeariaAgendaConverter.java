package br.com.barber.shop.infrastructure.converter;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendaRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendaResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaServico;
import br.com.barber.shop.infrastructure.database.entity.Profissional;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaServicoRepository;
import br.com.barber.shop.infrastructure.database.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BarbeariaAgendaConverter implements Function<BarbeariaAgendaRequest, BarbeariaAgenda> {


    @Autowired
    private BarbeariaServicoRepository servicoRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Override
    public BarbeariaAgenda apply(BarbeariaAgendaRequest request) {
        BarbeariaAgenda agenda = new BarbeariaAgenda();
        agenda.setDia(request.dia());
        agenda.setMes(request.mes());
        agenda.setAno(request.ano());
        agenda.setHora(request.hora());


        BarbeariaServico servico = servicoRepository.findById(request.servicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        agenda.setBarbeariaServico(servico);


        Profissional profissional = profissionalRepository.findById(request.profissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
        agenda.setProfissional(profissional);

        return agenda;
    }

    public BarbeariaAgendaResponse convertToResponse(BarbeariaAgenda agenda) {
        return new BarbeariaAgendaResponse(
                agenda.getId(),
                agenda.getDia(),
                agenda.getMes(),
                agenda.getAno(),
                agenda.getHora(),
                agenda.getProfissional().getId(),
                agenda.getBarbeariaServico().getId()
        );
    }
}


