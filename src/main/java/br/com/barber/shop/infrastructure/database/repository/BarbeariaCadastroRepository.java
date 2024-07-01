package br.com.barber.shop.infrastructure.database.repository;

import br.com.barber.shop.infrastructure.database.entity.BarbeariaCadastro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarbeariaCadastroRepository extends JpaRepository<BarbeariaCadastro, Long>{


}
