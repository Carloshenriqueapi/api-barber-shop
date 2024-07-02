package br.com.barber.shop.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

    @OneToMany(mappedBy = "barbearia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BarbeariaServico> servicos;

    private String email;
    private String telefone;
}
