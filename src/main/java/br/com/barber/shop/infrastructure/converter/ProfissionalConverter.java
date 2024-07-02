package br.com.barber.shop.infrastructure.converter;

import br.com.barber.shop.infrastructure.api.payload.request.ProfissionalRequest;
import br.com.barber.shop.infrastructure.api.payload.response.ProfissionalResponse;
import br.com.barber.shop.infrastructure.api.payload.response.ProfissionalEnderecoResponse;
import br.com.barber.shop.infrastructure.database.entity.Profissional;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProfissionalConverter implements Function<ProfissionalRequest, Profissional> {

    @Override
    public Profissional apply(ProfissionalRequest pessoa) {
        return Profissional.builder()
                .nome(pessoa.nome())
                .sobreNome(pessoa.sobreNome())
                .dataNascimento(pessoa.dataNascimento())
                .rg(pessoa.rg())
                .cpf(pessoa.cpf())
                .email(pessoa.email())
                .sexo(pessoa.sexo())
                .telefone(pessoa.telefone())
                .endereco(pessoa.endereco())

                .build();
    }

    public List<ProfissionalResponse> applyResponse(List<Profissional> list) {
        if (list != null && !list.isEmpty()) {
            return list.stream().map(this::applyResponse).collect(Collectors.toList());
        }
        return null;
    }

    public ProfissionalResponse applyResponse(Profissional profissional) {
        return new ProfissionalResponse(
                profissional.getNome(),
                profissional.getSobreNome(),
                profissional.getDataNascimento(),
                profissional.getRg(),
                profissional.getCpf(),
                profissional.getEmail(),
                profissional.getSexo(),
                profissional.getTelefone(),
                new ProfissionalEnderecoResponse(
                        profissional.getEndereco(),
                        profissional.getBairro(),
                        profissional.getCidade(),
                        profissional.getCep(),
                        profissional.getNumeroResidencia(),
                        profissional.getUf()
                )
        );
    }
}








