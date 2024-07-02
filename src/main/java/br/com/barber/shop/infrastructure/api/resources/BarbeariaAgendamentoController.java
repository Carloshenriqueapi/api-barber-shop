package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.core.service.BarbeariaAgendamentoService;
import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendamentoRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendaResponse;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendamentoResponse;
import br.com.barber.shop.infrastructure.converter.BarbeariaAgendamentoConverter;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgendamento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agendamento")
@AllArgsConstructor

public class BarbeariaAgendamentoController {

    private final BarbeariaAgendamentoService barbeariaAgendamentoService;
    private final BarbeariaAgendamentoConverter barbeariaAgendamentoConverter;

    @GetMapping
    public ResponseEntity<List<BarbeariaAgendamentoResponse>> listarTodos() {
        List<BarbeariaAgendamento> agendamentos = barbeariaAgendamentoService.getAllAgendamentos();
        List<BarbeariaAgendamentoResponse> response = barbeariaAgendamentoConverter.applyResponse(agendamentos);


        Collections.reverse(response);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaAgendamentoResponse> getBarbeariaAgendamentoById(@PathVariable Long id) {
        Optional<BarbeariaAgendamento> agendamento = barbeariaAgendamentoService.getAgendamentoById(id);
        return agendamento.map(barbeariaAgendamentoConverter::applyResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BarbeariaAgendamentoResponse> createAgenda(@RequestBody BarbeariaAgendamentoRequest agendamento) {
        BarbeariaAgendamentoResponse response = barbeariaAgendamentoService.createAgendamento(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarbeariaAgendamento(@PathVariable Long id) {
        barbeariaAgendamentoService.deleteBarbeariaAgendamento(id);
        return ResponseEntity.ok().build();
    }
}

