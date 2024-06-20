package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.infrastructure.database.entity.Cliente;
import br.com.barber.shop.core.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllCliente() {
        return clienteService.getAllCliente();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCLiente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok().build();
    }


}
