package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.core.service.ProfissionaisService;
import br.com.barber.shop.infrastructure.api.payload.request.ProfissionalRequest;
import br.com.barber.shop.infrastructure.api.payload.response.ProfissionalResponse;
import br.com.barber.shop.infrastructure.database.entity.Profissional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profissionais")
@AllArgsConstructor
public class ProfissionalController {

    private final ProfissionaisService profissionalService;

    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>> getAllProfissional() {
        List<ProfissionalResponse> profissionais = profissionalService.getAllProfissional();
        return ResponseEntity.ok(profissionais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> getProfissionalById(@PathVariable Long id) {
        Optional<ProfissionalResponse> profissional = profissionalService.getProfissionalById(id);
        return profissional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProfissionalResponse> createProfissional(@RequestBody ProfissionalRequest profissionalRequest) {
        ProfissionalResponse profissionalResponse = profissionalService.createProfissional(profissionalRequest);
        return ResponseEntity.ok(profissionalResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfissional(@PathVariable Long id) {
        profissionalService.deleteProfissional(id);
        return ResponseEntity.noContent().build();
    }
}

