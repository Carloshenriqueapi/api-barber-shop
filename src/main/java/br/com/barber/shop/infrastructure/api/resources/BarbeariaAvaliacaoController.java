package br.com.barber.shop.infrastructure.api.resources;

import br.com.barber.shop.core.service.BarbeariaAvaliacaoService;
import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAvaliacaoRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAvaliacaoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
public class BarbeariaAvaliacaoController {
   private final BarbeariaAvaliacaoService avaliacaoService;

   public BarbeariaAvaliacaoController(BarbeariaAvaliacaoService avaliacaoService) {
       this.avaliacaoService = avaliacaoService;
   }

   @PostMapping
   public ResponseEntity<BarbeariaAvaliacaoResponse> criarAvaliacao(@RequestBody BarbeariaAvaliacaoRequest request) {
     BarbeariaAvaliacaoResponse response = avaliacaoService.criarAvaliacao(request);
     return ResponseEntity.ok(response);
   }


}

