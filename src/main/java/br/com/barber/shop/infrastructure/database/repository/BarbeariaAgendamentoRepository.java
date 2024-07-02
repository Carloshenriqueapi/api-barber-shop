package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BarbeariaAgendamentoRepository extends JpaRepository<BarbeariaAgendamento, Long> {
}
