package br.com.barber.shop.infrastructure.converter;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaCadastroRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaCadastroResponse;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaEnderecoResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaCadastro;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaEndereco;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BarbeariaCadastroConverter implements Function<BarbeariaCadastroRequest, BarbeariaCadastro> {

    @Override
    public BarbeariaCadastro apply(BarbeariaCadastroRequest barbeariaCadastroRequest) {

        return BarbeariaCadastro.builder()
                .razaoSocial(barbeariaCadastroRequest.razaoSocial())
                .nomeFantasia(barbeariaCadastroRequest.nomeFantasia())
                .cnpj(barbeariaCadastroRequest.cnpj())
                .endereco(
                        BarbeariaEndereco.builder()
                                .rua(barbeariaCadastroRequest.endereco().rua())
                                .bairro(barbeariaCadastroRequest.endereco().bairro())
                                .cidade(barbeariaCadastroRequest.endereco().cidade())
                                .cep(barbeariaCadastroRequest.endereco().cep())
                                .estado(barbeariaCadastroRequest.endereco().estado())
                                .build()

                )
                .email(barbeariaCadastroRequest.email())
                .telefone(barbeariaCadastroRequest.telefone())
                .build();
    }

    public List<BarbeariaCadastroResponse> applyResponse(List<BarbeariaCadastro> list) {

        if(list != null && !list.isEmpty()) {
            return list.stream().map(barberia -> {

                return new BarbeariaCadastroResponse(
                        barberia.getRazaoSocial(),
                        barberia.getNomeFantasia(),
                        barberia.getCnpj(),
                        new BarbeariaEnderecoResponse(
                                barberia.getEndereco().getRua(),
                                barberia.getEndereco().getBairro(),
                                barberia.getEndereco().getCidade(),
                                barberia.getEndereco().getCep(),
                                barberia.getEndereco().getEstado()),
                        barberia.getEmail(),
                        barberia.getTelefone());

            }).collect(Collectors.toList());
        }
        return null;

    }

    public BarbeariaCadastroResponse applyResponse(BarbeariaCadastro barberia) {
        return new BarbeariaCadastroResponse(
                barberia.getRazaoSocial(),
                barberia.getNomeFantasia(),
                barberia.getCnpj(),
                new BarbeariaEnderecoResponse(
                        barberia.getEndereco().getRua(),
                        barberia.getEndereco().getBairro(),
                        barberia.getEndereco().getCidade(),
                        barberia.getEndereco().getCep(),
                        barberia.getEndereco().getEstado()),
                barberia.getEmail(),
                barberia.getTelefone());
    }
}
