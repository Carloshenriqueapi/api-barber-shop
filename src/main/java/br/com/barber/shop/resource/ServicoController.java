package br.com.barber.shop.resource;

import br.com.barber.shop.entity.Servico;
import br.com.barber.shop.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")

public class ServicoController {
    @Autowired
    private ServicoService servicoService;
    @GetMapping
    public List<Servico> getAllServicos() {
        return servicoService.findAll();
    }
    @PostMapping
    public Servico createServico(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable Long id, @RequestBody Servico servicoDetails) {
        return servicoService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteServico(@PathVariable Long id) {
        servicoService.deleteById(id);
    }

}
