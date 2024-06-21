package br.com.barber.shop.infrastructure.api.payload.response;

public record BarbeariaCadastroResponse(
        String razaoSocial,
        String nomeFantasia,
        String cnpj,
        BarbeariaEnderecoResponse endereco,
        String email,
        String telefone) {
}