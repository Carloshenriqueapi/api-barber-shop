package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeariaAgendaRepository extends JpaRepository<BarbeariaAgenda, Long> {

}
