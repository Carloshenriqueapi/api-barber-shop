package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaCadastroRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaCadastroResponse;
import br.com.barber.shop.core.service.BarbeariaCadastroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/barbearia")
@AllArgsConstructor
public class BarbeariaCadastroController {

    private final BarbeariaCadastroService barbeariaService;

    @GetMapping
    public List<BarbeariaCadastroResponse> getAllBarbearia() {
        return  barbeariaService.getAllBarbearia();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaCadastroResponse> getBarbeariaById(@PathVariable Long id) {
        return barbeariaService.getBarbeariaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BarbeariaCadastroResponse createBarbearia(@RequestBody BarbeariaCadastroRequest barbearia) {
        return barbeariaService.createBarbearia(barbearia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarbearia(@PathVariable Long id) {
        barbeariaService.deleteBarbearia(id);
        return ResponseEntity.ok().build();
    }
}

