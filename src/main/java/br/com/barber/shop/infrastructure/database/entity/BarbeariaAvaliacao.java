package br.com.barber.shop.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BarbeariaAvaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private BarbeariaServico servico;

    @Column(nullable = false)
    private int estrelas;

    @Column(nullable = false, length = 500)
    private String texto;
}

