package br.com.barber.shop.infrastructure.converter;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaCadastroRequest;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaCadastro;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaEndereco;
import org.springframework.stereotype.Component;
import java.util.function.Function;

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
}
