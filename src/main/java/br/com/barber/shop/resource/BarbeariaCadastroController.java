package br.com.barber.shop.resource;

import br.com.barber.shop.entity.BarbeariaCadastro;
import br.com.barber.shop.service.BarbeariaCadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/barbearia")
public class BarbeariaCadastroController {
    @Autowired
    private BarbeariaCadastroService barbeariaService;

    @GetMapping
    public List<BarbeariaCadastro> getAllBarbearia() {
        return  barbeariaService.getAllBarbearia();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaCadastro> getBarbeariaById(@PathVariable Long id) {
        return barbeariaService.getBarbeariaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BarbeariaCadastro createBarbearia(@RequestBody BarbeariaCadastro barbearia) {
        return barbeariaService.createBarbearia(barbearia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarbearia(@PathVariable Long id) {
        barbeariaService.deleteBarbearia(id);
        return ResponseEntity.ok().build();
    }
}

