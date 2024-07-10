package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.api.payload.request.ProfissionalRequest;
import br.com.barber.shop.infrastructure.api.payload.response.ProfissionalResponse;
import br.com.barber.shop.infrastructure.converter.ProfissionalConverter;
import br.com.barber.shop.infrastructure.database.entity.Profissional;
import br.com.barber.shop.infrastructure.database.repository.ProfissionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfissionaisService {



    private final ProfissionalRepository profissionalRepository;
    private final ProfissionalConverter profissionalConverter;

    public List<ProfissionalResponse> getAllProfissional() {
        List<Profissional> profissionais = profissionalRepository.findAll();
        return profissionalConverter.convertToResponseList(profissionais);
    }

    public Optional<ProfissionalResponse> getProfissionalById(Long id) {
        Optional<Profissional> profissional = profissionalRepository.findById(id);
        return profissional.map(profissionalConverter::convertToResponse);
    }

    public ProfissionalResponse createProfissional(ProfissionalRequest profissionalRequest) {
        Profissional profissional = profissionalConverter.apply(profissionalRequest);
        Profissional savedProfissional = profissionalRepository.save(profissional);
        return profissionalConverter.convertToResponse(savedProfissional);
    }

    public void deleteProfissional(Long id) {
        profissionalRepository.deleteById(id);
    }
}


