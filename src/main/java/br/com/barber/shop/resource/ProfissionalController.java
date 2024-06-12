package br.com.barber.shop.resource;

import br.com.barber.shop.entity.Profissional;
import br.com.barber.shop.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;
    @GetMapping
    public List<Profissional> getAllProfissionais() {
        return profissionalService.getAllProfissionais();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getProfissionalById(@PathVariable Long id) {
        Optional<Profissional> profissional = profissionalService.getProfissionalById(id);
        if (profissional.isPresent()) {
            return ResponseEntity.ok(profissional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Profissional createProfissional(@RequestBody Profissional profissional) {
        return profissionalService.createProfissional(profissional);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfissional(@PathVariable Long id) {
        profissionalService.deleteProfissional(id);
        return ResponseEntity.noContent().build();
    }
}

