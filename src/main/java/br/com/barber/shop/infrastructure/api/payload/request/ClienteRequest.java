package br.com.barber.shop.infrastructure.api.payload.request;

import lombok.Builder;

@Builder
public record ClienteRequest (
        String nome,
        String sobreNome,
        String cpf,
        String rg,
        String email,
        String telefone,
        ClienteEnderecoRequest endereco
) {}
