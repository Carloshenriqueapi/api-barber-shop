package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
