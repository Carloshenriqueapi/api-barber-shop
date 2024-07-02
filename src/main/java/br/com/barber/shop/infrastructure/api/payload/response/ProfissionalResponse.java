package br.com.barber.shop.infrastructure.api.payload.response;

import lombok.Builder;

@Builder
public record ProfissionalResponse(

        String nome,
        String sobreNome,
        String dataNascimento,
        String rg,
        String cpf,
        String email,
        String sexo,
        String telefone,
        ProfissionalEnderecoResponse endereco){

}
