package br.com.barber.shop.repository;

import br.com.barber.shop.entity.BarbeariaCadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeariaCadastroRepository extends JpaRepository <BarbeariaCadastro, Long>{
}
