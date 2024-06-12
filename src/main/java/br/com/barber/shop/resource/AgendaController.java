package br.com.barber.shop.resource;

import br.com.barber.shop.entity.Agenda;
import br.com.barber.shop.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agenda")

public class AgendaController {
    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping("/listar")
    public List<Agenda> listarAgendas() {
        return agendaService.listarTodos();
    }
}
