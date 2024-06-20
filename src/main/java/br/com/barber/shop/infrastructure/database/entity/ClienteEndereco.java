package br.com.barber.shop.infrastructure.database.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteEndereco {
    private String endereco;
    private String bairro;
    private String cep;
    private String numeroResidencia;
    private Character uf;
}
