package br.com.barber.shop.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfissionalEndereco {
    private String endereco;
    private String bairro;
    private String cep;
    private String numeroResidencia;
    private Character uf;
}
