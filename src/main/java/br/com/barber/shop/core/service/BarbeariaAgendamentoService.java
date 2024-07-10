package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendamentoRequest;
import br.com.barber.shop.infrastructure.converter.BarbeariaAgendamentoConverter;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgendamento;
import br.com.barber.shop.infrastructure.database.entity.Cliente;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaAgendaRepository;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaAgendamentoRepository;
import br.com.barber.shop.infrastructure.database.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeariaAgendamentoService {

    private final BarbeariaAgendamentoRepository barbeariaAgendamentoRepository;
    private final BarbeariaAgendaRepository barbeariaAgendaRepository;
    private final ClienteRepository clienteRepository;
    private final BarbeariaAgendamentoConverter barbeariaAgendamentoConverter;

    public BarbeariaAgendamentoService(BarbeariaAgendamentoRepository barbeariaAgendamentoRepository,
                                       BarbeariaAgendaRepository barbeariaAgendaRepository,
                                       ClienteRepository clienteRepository,
                                       BarbeariaAgendamentoConverter barbeariaAgendamentoConverter) {
        this.barbeariaAgendamentoRepository = barbeariaAgendamentoRepository;
        this.barbeariaAgendaRepository = barbeariaAgendaRepository;
        this.clienteRepository = clienteRepository;
        this.barbeariaAgendamentoConverter = barbeariaAgendamentoConverter;
    }

    public List<BarbeariaAgendamento> getAllAgendamentos() {
        return barbeariaAgendamentoRepository.findAll();
    }

    public Optional<BarbeariaAgendamento> getAgendamentoById(Long id) {
        return barbeariaAgendamentoRepository.findById(id);
    }

    public String createAgendamento(BarbeariaAgendamentoRequest request) {
        Long agendaId = request.getAgendaId();
        Optional<BarbeariaAgenda> agendaOptional = barbeariaAgendaRepository.findById(agendaId);
        BarbeariaAgenda agenda = agendaOptional.orElseThrow(() -> new RuntimeException("Agenda não encontrada com ID: " + agendaId));

        Long clienteId = request.getClienteId();
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        Cliente cliente = clienteOptional.orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + clienteId));

        BarbeariaAgendamento agendamento = new BarbeariaAgendamento();
        agendamento.setAgenda(agenda);
        agendamento.setCliente(cliente);

        barbeariaAgendamentoRepository.save(agendamento);

        agenda.setStatus("Agendado");
        barbeariaAgendaRepository.save(agenda);

        return "Agendamento realizado com sucesso!";
    }

    public void deleteBarbeariaAgendamento(Long id) {
        barbeariaAgendamentoRepository.deleteById(id);
    }
}



