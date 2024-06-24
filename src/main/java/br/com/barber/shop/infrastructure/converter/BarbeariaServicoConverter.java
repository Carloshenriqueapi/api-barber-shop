package br.com.barber.shop.infrastructure.converter;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaServicoRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaServicoResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaServico;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class BarbeariaServicoConverter implements Function<BarbeariaServicoRequest, BarbeariaServico> {

    @Override
    public BarbeariaServico apply(BarbeariaServicoRequest barbeariaServicoRequest) {
        return BarbeariaServico.builder()
                .nome(barbeariaServicoRequest.nome())
                .valor(barbeariaServicoRequest.valor())
                .ativo(barbeariaServicoRequest.ativo())
                .build();
    }

    public List<BarbeariaServicoResponse> applyResponse(List<BarbeariaServico> all) {
        if (all != null && !all.isEmpty()) {
            return all.stream()
                    .map(servico -> new BarbeariaServicoResponse(
                            servico.getNome(),
                            servico.getValor(),
                            servico.getAtivo()
                    )).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public BarbeariaServicoResponse apply(BarbeariaServico barbeariaServico) {
        return new BarbeariaServicoResponse(
                barbeariaServico.getNome(),
                barbeariaServico.getValor(),
                barbeariaServico.getAtivo());
    }

}





