package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.infrastructure.database.entity.Pagamento;
import br.com.barber.shop.core.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> criarPagamento(@RequestBody Pagamento pagamento) {
        Pagamento pagamentoProcessado = pagamentoService.processarPagamento(pagamento);
        return ResponseEntity.ok(pagamentoProcessado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> obterPagamento(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoService.obterPagamento(id);
        return pagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
