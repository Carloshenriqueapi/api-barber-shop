package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.core.service.BarbeariaAgendaService;
import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendaRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendaResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/agenda")
@AllArgsConstructor
public class BarbeariaAgendaController {

    private final BarbeariaAgendaService barbeariaService;

    @GetMapping
    public ResponseEntity<List<BarbeariaAgendaResponse>> listarTodos() {
        List<BarbeariaAgenda> agenda = barbeariaService.getAllAgenda();

        List<BarbeariaAgendaResponse> response = agenda.stream()
                .map(barbeariaAgenda -> new BarbeariaAgendaResponse(
                        barbeariaAgenda.getDia(),
                        barbeariaAgenda.getHora(),
                        barbeariaAgenda.getMes(),
                        barbeariaAgenda.getAno()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaAgendaResponse> getBarbeariaAgendaById(@PathVariable Long id) {
        Optional<BarbeariaAgenda> agenda = barbeariaService.getBarbeariaById(id);

        return agenda.map(barbeariaAgenda ->
                ResponseEntity.ok(
                        new BarbeariaAgendaResponse(
                                barbeariaAgenda.getDia(),
                                barbeariaAgenda.getHora(),
                                barbeariaAgenda.getMes(),
                                barbeariaAgenda.getAno())
                )
        ).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/barbearia")
    public ResponseEntity<BarbeariaAgendaResponse> createAgenda(@RequestBody BarbeariaAgendaRequest agenda) {
        BarbeariaAgendaResponse response = barbeariaService.createAgenda(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarbeariaAgenda(@PathVariable Long id) {
        barbeariaService.deleteBarbeariaAgenda(id);
        return ResponseEntity.ok().build();
    }

 }






