package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.database.entity.Pagamento;
import br.com.barber.shop.infrastructure.database.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    public Pagamento processarPagamento(Pagamento pagamento) {
        pagamento.setStatus("processado");
        return pagamentoRepository.save(pagamento);
    }
    public Optional<Pagamento> obterPagamento(Long id) {
        return pagamentoRepository.findById(id);
    }

}
