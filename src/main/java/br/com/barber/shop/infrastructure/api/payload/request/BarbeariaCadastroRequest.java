package br.com.barber.shop.infrastructure.api.payload.request;

public record BarbeariaCadastroRequest(
        String razaoSocial,
        String nomeFantasia,
        String cnpj,
        BarbeariaEnderecoRequest endereco,
        String email,
        String telefone) {
}