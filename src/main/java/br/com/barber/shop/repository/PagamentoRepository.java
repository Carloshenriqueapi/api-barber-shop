package br.com.barber.shop.repository;

import br.com.barber.shop.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository  extends JpaRepository<Pagamento, Long> {

}
