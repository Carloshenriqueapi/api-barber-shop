package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
