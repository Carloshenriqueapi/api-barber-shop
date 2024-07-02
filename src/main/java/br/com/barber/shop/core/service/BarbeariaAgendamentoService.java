package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendamentoRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendamentoResponse;
import br.com.barber.shop.infrastructure.converter.BarbeariaAgendamentoConverter;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgendamento;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaAgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeariaAgendamentoService {

    private final BarbeariaAgendamentoRepository barbeariaAgendamentoRepository;
    private final BarbeariaAgendamentoConverter barbeariaAgendamentoConverter;

    public BarbeariaAgendamentoService(BarbeariaAgendamentoRepository barbeariaAgendamentoRepository, BarbeariaAgendamentoConverter barbeariaAgendamentoConverter) {
        this.barbeariaAgendamentoRepository = barbeariaAgendamentoRepository;
        this.barbeariaAgendamentoConverter = barbeariaAgendamentoConverter;
    }

    public List<BarbeariaAgendamento> getAllAgendamentos() {
        return barbeariaAgendamentoRepository.findAll();
    }

    public Optional<BarbeariaAgendamento> getAgendamentoById(Long id) {
        return barbeariaAgendamentoRepository.findById(id);
    }

    public BarbeariaAgendamentoResponse createAgendamento(final BarbeariaAgendamentoRequest agendamento) {
        BarbeariaAgendamento convertedAgendamento = barbeariaAgendamentoConverter.apply(agendamento);
        BarbeariaAgendamento savedAgendamento = barbeariaAgendamentoRepository.save(convertedAgendamento);
        return barbeariaAgendamentoConverter.applyResponse(savedAgendamento);
    }

    public void deleteBarbeariaAgendamento(Long id) {
        barbeariaAgendamentoRepository.deleteById(id);
    }
}


