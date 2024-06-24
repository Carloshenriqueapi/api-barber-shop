package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaServicoRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaServicoResponse;
import br.com.barber.shop.infrastructure.converter.BarbeariaServicoConverter;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaServico;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaServicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BarbeariaServicoService {


    private final BarbeariaServicoRepository barbeariaServicoRepository;
    private final BarbeariaServicoConverter barbeariaServicoConverter;

    public List<BarbeariaServicoResponse> getAllBarbeariaServiço() {
        return this.barbeariaServicoConverter.applyResponse(barbeariaServicoRepository.findAll());
    }

    public BarbeariaServicoResponse getBarbeariaServicoById(Long id) {
        Optional<BarbeariaServico> barbeariaServicoOptional = barbeariaServicoRepository.findById(id);

        if (barbeariaServicoOptional.isPresent()) {
            return this.barbeariaServicoConverter.apply(barbeariaServicoOptional.get());
        } else {
            return null;
        }
    }

    public List<BarbeariaServicoResponse> createBarbeariaServico(final BarbeariaServicoRequest barbeariaServico) {
        return this.barbeariaServicoConverter.applyResponse(
                Collections.singletonList(barbeariaServicoRepository.save(
                       this.barbeariaServicoConverter.apply(barbeariaServico)
                ))
        );
    }
    public void deleteBarbeariaSevico(Long id) {
        barbeariaServicoRepository.deleteById(id);
    }
}



