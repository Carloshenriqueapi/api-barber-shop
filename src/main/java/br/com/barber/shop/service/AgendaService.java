package br.com.barber.shop.service;

import br.com.barber.shop.entity.Agenda;
import br.com.barber.shop.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository; {
}
@Autowired
public AgendaService(AgendaRepository agendaRepository, AgendaRepository agendaRepository1) {
    this.agendaRepository = agendaRepository;
}
public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
}

}
