package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.core.service.BarbeariaAgendaService;
import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAgendaRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAgendaResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/barbearia_agenda")
@AllArgsConstructor
public class BarbeariaAgendaController {

    private final BarbeariaAgendaService barbeariaService;

    @GetMapping
    public ResponseEntity<List<BarbeariaAgendaResponse>> listarTodos() {
        List<BarbeariaAgenda> agendaList = barbeariaService.getAllAgenda();
        List<BarbeariaAgendaResponse> response = agendaList.stream()
                .map(barbeariaService::convertToResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBarbeariaAgendaById(@PathVariable Long id) {
        Optional<BarbeariaAgenda> agendaOptional = barbeariaService.getBarbeariaById(id);

        if (agendaOptional.isEmpty()) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Agenda não encontrada para o ID fornecido");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        BarbeariaAgenda barbeariaAgenda = agendaOptional.get();
        BarbeariaAgendaResponse response = barbeariaService.convertToResponse(barbeariaAgenda);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createAgenda(@RequestBody BarbeariaAgendaRequest agendaRequest) {
        Long profissionalId = agendaRequest.profissionalId();
        if (profissionalId == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "ID do profissional não pode ser nulo");
            errorResponse.put("request", agendaRequest);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        try {
            BarbeariaAgendaResponse agendaResponse = barbeariaService.createAgenda(agendaRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("agenda", agendaResponse));
        } catch (EntityNotFoundException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Profissional não encontrado");
            errorResponse.put("request", agendaRequest);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Erro ao criar agenda");
            errorResponse.put("request", agendaRequest);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    @PatchMapping("/status")
    public ResponseEntity<String> atualizarStatus(@RequestBody BarbeariaAgendaRequest request) {
        try {
            String mensagem;
            if ("agendado".equalsIgnoreCase(request.status())) {
                mensagem = "Horário agendado com sucesso!";
            } else if ("cancelado".equalsIgnoreCase(request.status())) {
                mensagem = "Horário cancelado com sucesso!";
            } else {
                return ResponseEntity.badRequest().body("Status inválido. Utilize 'agendado' ou 'cancelado'.");
            }

            barbeariaService.atualizarStatus(request.agendaId(), request.status());

            return ResponseEntity.ok(mensagem);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // Retorna 404 se a entidade não for encontrada
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarbeariaAgenda(@PathVariable Long id) {
        barbeariaService.deleteBarbeariaAgenda(id);
        return ResponseEntity.ok().build();
    }
}






