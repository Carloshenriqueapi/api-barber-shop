package br.com.barber.shop.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nome;
    private String sobreNome;
    private LocalDate dataNascimento;
    private String rg;
    private String cpf;
    private String email;
    private Character sexo;
    private String telefone;
    private String endereco;
}
