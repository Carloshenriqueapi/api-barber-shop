package br.com.barber.shop.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
public class BarbeariaCadastro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    private BarbeariaEndereco endereco;

    private String email;
    private String telefone;
}
