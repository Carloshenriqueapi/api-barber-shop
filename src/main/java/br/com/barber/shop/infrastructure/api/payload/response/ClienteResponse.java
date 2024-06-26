package br.com.barber.shop.infrastructure.api.payload.response;

import lombok.Builder;

@Builder
public record ClienteResponse (
        String nome,
        String sobreNome,
        String dataNascimento,
        String cpf,
        String rg,
        String sexo,
        String email,
        ClienteEnderecoResponse endereco
) {}
