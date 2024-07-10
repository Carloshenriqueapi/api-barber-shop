package br.com.barber.shop.infrastructure.api.payload.request;

import lombok.Builder;

@Builder
public record ProfissionalRequest(
        Long idBarbearia,
        String nome,
        String sobreNome,
        String dataNascimento,
        String rg,
        String cpf,
        String email,
        String sexo,
        String telefone,
        String endereco){

}
