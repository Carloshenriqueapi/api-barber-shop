package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.database.entity.BarbeariaPagamento;
import br.com.barber.shop.infrastructure.database.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BarbeariaPagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    public BarbeariaPagamento processarPagamento(BarbeariaPagamento pagamento) {
        pagamento.setStatus("processado");
        return pagamentoRepository.save(pagamento);
    }
    public Optional<BarbeariaPagamento> obterPagamento(Long id) {
        return pagamentoRepository.findById(id);
    }

}
