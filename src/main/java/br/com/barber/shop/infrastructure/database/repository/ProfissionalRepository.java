package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}


