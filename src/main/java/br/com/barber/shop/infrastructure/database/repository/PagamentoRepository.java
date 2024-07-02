package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.BarbeariaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository  extends JpaRepository<BarbeariaPagamento, Long> {

}
