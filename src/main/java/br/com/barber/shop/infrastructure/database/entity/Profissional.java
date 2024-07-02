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
public class Profissional {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        private String nome;
        private String sobreNome;
        private String dataNascimento;
        private String rg;
        private String cpf;
        private String email;
        private String sexo;
        private String telefone;
        private String endereco;
        private String bairro;
        private String cidade;
        private String cep;
        private String numeroResidencia;
        private String uf;

}
