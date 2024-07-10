package br.com.barber.shop.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;


@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BarbeariaServico  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "barbearia_id")
    private BarbeariaCadastro barbearia;

    private String nome;
    private Double valor;
    private Boolean ativo;


}