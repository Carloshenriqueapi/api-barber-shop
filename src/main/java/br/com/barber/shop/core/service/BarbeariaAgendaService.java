package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendaRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendaResponse;
import br.com.barber.shop.infrastructure.converter.BarbeariaAgendaConverter;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaAgendaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service

public class BarbeariaAgendaService {

    private final BarbeariaAgendaRepository barbeariaAgendaRepository;
    private final BarbeariaAgendaConverter barbeariaAgendaConverter;

    public BarbeariaAgendaService(BarbeariaAgendaRepository barbeariaAgendaRepository, BarbeariaAgendaConverter barbeariaAgendaConverter) {
        this.barbeariaAgendaRepository = barbeariaAgendaRepository;
        this.barbeariaAgendaConverter = barbeariaAgendaConverter;
    }

    public List<BarbeariaAgenda> getAllAgenda() {
        return barbeariaAgendaRepository.findAll();
    }

    public Optional<BarbeariaAgenda> getBarbeariaById(Long id) {
        return barbeariaAgendaRepository.findById(id);
    }

    public BarbeariaAgendaResponse createAgenda(final BarbeariaAgendaRequest agenda) {
        BarbeariaAgenda convertedAgenda = barbeariaAgendaConverter.apply(agenda);
        BarbeariaAgenda savedAgenda = barbeariaAgendaRepository.save(convertedAgenda);
        return barbeariaAgendaConverter.applyResponse(savedAgenda);
    }
    public void deleteBarbeariaAgenda(Long id) {
        barbeariaAgendaRepository.deleteById(id);
    }
}







