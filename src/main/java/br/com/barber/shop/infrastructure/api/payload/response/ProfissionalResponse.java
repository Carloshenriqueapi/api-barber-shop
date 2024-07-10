package br.com.barber.shop.infrastructure.api.payload.response;

import lombok.Builder;

@Builder
public record ProfissionalResponse(
        Long id,
        Long idBarbeariaCadastro,
        String nome,
        String sobreNome,
        String dataNascimento,
        String rg,
        String cpf,
        String email,
        String sexo,
        String telefone,
        String endereco,
        String bairro,
        String cidade,
        String cep,
        String numeroResidencia,
        String uf
) {}
