package br.com.barber.shop.infrastructure.api.payload.request;

import lombok.Builder;

@Builder
public record ClienteEnderecoRequest(
        String rua,
        String bairro,
        String cidade,
        String cep,
        String numeroResidencia,
        String uf
) {}
