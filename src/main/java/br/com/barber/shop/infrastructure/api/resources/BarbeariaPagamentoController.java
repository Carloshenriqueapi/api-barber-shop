package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.infrastructure.database.entity.BarbeariaPagamento;
import br.com.barber.shop.core.service.BarbeariaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/pagamentos")
public class BarbeariaPagamentoController {
    @Autowired
    private BarbeariaPagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<BarbeariaPagamento> criarPagamento(@RequestBody BarbeariaPagamento pagamento) {
        BarbeariaPagamento pagamentoProcessado = pagamentoService.processarPagamento(pagamento);
        return ResponseEntity.ok(pagamentoProcessado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaPagamento> obterPagamento(@PathVariable Long id) {
        Optional<BarbeariaPagamento> pagamento = pagamentoService.obterPagamento(id);
        return pagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
