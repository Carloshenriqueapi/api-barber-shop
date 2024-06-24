package br.com.barber.shop.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BarbeariaCadastro implements Serializable {


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
