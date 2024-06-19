package br.com.barber.shop.repository;

import br.com.barber.shop.entity.BarbeariaCadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeariaRepository extends JpaRepository <BarbeariaCadastro, Long>{
}
