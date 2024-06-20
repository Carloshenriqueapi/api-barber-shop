package br.com.barber.shop.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Builder
@Entity
public class BarbeariaEndereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

}
