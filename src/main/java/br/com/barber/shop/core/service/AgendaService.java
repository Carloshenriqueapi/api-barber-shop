package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.database.entity.Agenda;
import br.com.barber.shop.infrastructure.database.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository; {
}
@Autowired
public AgendaService(AgendaRepository agendaRepository) {
    this.agendaRepository = agendaRepository;
}
public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
}

}
