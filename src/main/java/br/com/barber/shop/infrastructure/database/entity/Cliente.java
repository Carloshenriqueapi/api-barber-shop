package br.com.barber.shop.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobreNome;
    private String dataNascimento;
    private String cpf;
    private String rg;
    private String sexo;
    private String email;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    private ClienteEndereco endereco;

}




