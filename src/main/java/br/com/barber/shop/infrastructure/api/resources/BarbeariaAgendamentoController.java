package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.core.service.BarbeariaAgendamentoService;
import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendamentoRequest;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgendamento;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class BarbeariaAgendamentoController {

    private final BarbeariaAgendamentoService agendamentoService;

    public BarbeariaAgendamentoController(BarbeariaAgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public List<BarbeariaAgendamento> getAllAgendamentos() {
        return agendamentoService.getAllAgendamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaAgendamento> getAgendamentoById(@PathVariable Long id) {
        return agendamentoService.getAgendamentoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> criarAgendamento(@RequestBody BarbeariaAgendamentoRequest request) {
        String response = agendamentoService.createAgendamento(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable Long id) {
        agendamentoService.deleteBarbeariaAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}

