package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaServicoRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaCadastroResponse;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaServicoResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaServico;
import br.com.barber.shop.core.service.BarbeariaServicoService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Builder
@RestController
@RequestMapping("/api/servicos")

public class ServicoController {

    private final BarbeariaServicoService servicoService;
    @GetMapping
    public List<BarbeariaServicoResponse> getAllServicos() {
        return servicoService.getAllBarbeariaServiço();

    }
    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaServicoResponse> updateServico(@PathVariable Long id) {
        return ResponseEntity.ok(this.servicoService.getBarbeariaServicoById(id));
    }

    @PostMapping
    public List<BarbeariaServicoResponse> createServico(@RequestBody BarbeariaServicoRequest servico) {
        return servicoService.createBarbeariaServico(servico);
    }

    @DeleteMapping("/{id}")
    public void deleteServico(@PathVariable Long id) {
        servicoService.deleteBarbeariaSevico(id);
    }
    private ResponseEntity<BarbeariaServicoResponse> builder(Object barbeariaServicoResponse) {
        return null;
    }

}
