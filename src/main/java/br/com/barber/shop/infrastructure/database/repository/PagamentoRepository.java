package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository  extends JpaRepository<Pagamento, Long> {

}
