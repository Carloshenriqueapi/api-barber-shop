package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.BarbeariaAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeariaAvaliacaoRepository extends JpaRepository<BarbeariaAvaliacao, Long> {
}
