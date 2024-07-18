package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendaRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendaResponse;
import br.com.barber.shop.infrastructure.converter.BarbeariaAgendaConverter;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import br.com.barber.shop.infrastructure.database.entity.Profissional;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaAgendaRepository;
import br.com.barber.shop.infrastructure.database.repository.ProfissionalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@AllArgsConstructor
@Service
@Slf4j
public class BarbeariaAgendaService {


    private final Function<BarbeariaAgendaRequest, BarbeariaAgenda> barbeariaAgendaConverter;
    private final BarbeariaAgendaConverter barbeariaAgendaConverterInstance;
    private final ProfissionalRepository profissionalRepository;
    private final BarbeariaAgendaRepository barbeariaAgendaRepository;

    @Transactional
    public BarbeariaAgendaResponse createAgenda(BarbeariaAgendaRequest agendaRequest) {
        log.info("Criando agenda para profissionalId: {}", agendaRequest.profissionalId());

        Profissional profissional = profissionalRepository.findById(agendaRequest.profissionalId())
                .orElseThrow(() -> {
                    log.error("Profissional com id {} não encontrado", agendaRequest.profissionalId());
                    return new EntityNotFoundException("Profissional não encontrado");
                });

        BarbeariaAgenda agenda = barbeariaAgendaConverter.apply(agendaRequest);
        agenda.setProfissional(profissional);

        BarbeariaAgenda savedAgenda = barbeariaAgendaRepository.save(agenda);
        log.info("Agenda criada com sucesso: {}", savedAgenda);

        return barbeariaAgendaConverterInstance.convertToResponse(savedAgenda);
    }

    @Transactional
    public void atualizarStatus(Long agendaId, String status) {
        BarbeariaAgenda agenda = barbeariaAgendaRepository.findById(agendaId)
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada"));

        agenda.setStatus(status);
        barbeariaAgendaRepository.save(agenda);
    }

    public Optional<BarbeariaAgenda> getBarbeariaById(Long id) {
        return barbeariaAgendaRepository.findByIdWithProfissional(id);
    }

    public List<BarbeariaAgenda> getAllAgenda() {
        return barbeariaAgendaRepository.findAll();
    }

    public BarbeariaAgendaResponse convertToResponse(BarbeariaAgenda agenda) {
        return barbeariaAgendaConverterInstance.convertToResponse(agenda);
    }

    public void deleteBarbeariaAgenda(Long id) {
        barbeariaAgendaRepository.deleteById(id);
    }
}







