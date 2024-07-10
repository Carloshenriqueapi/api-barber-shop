package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.BarbeariaAgenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarbeariaAgendaRepository extends JpaRepository<BarbeariaAgenda, Long> {
    Optional<BarbeariaAgenda> findById(Long id);

    @Query("SELECT ba FROM BarbeariaAgenda ba LEFT JOIN FETCH ba.profissional WHERE ba.id = :id")
    Optional<BarbeariaAgenda> findByIdWithProfissional(@Param("id") Long id);

}
