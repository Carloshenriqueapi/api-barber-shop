package br.com.barber.shop.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BarbeariaAgenda")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BarbeariaAgenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String nome;
    private String dia;
    private String mes;
    private String ano;
    private String hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id")
    private BarbeariaServico barbeariaServico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BarbeariaAgendamento> agendamentos = new ArrayList<>();


}
