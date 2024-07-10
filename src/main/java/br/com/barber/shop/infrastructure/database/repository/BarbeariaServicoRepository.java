package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.BarbeariaServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BarbeariaServicoRepository extends JpaRepository<BarbeariaServico, Long> {

}


