package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaCadastroRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaCadastroResponse;
import br.com.barber.shop.infrastructure.converter.BarbeariaCadastroConverter;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaCadastro;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaCadastroRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BarbeariaCadastroService {

    private final BarbeariaCadastroRepository barbeariaRepository;

    private final BarbeariaCadastroConverter barbeariaCadastroConverter;

    public List<BarbeariaCadastroResponse> getAllBarbearia() {
        return this.barbeariaCadastroConverter.applyResponse(barbeariaRepository.findAll());
    }

    public Optional<BarbeariaCadastroResponse> getBarbeariaById(Long id) {
        return Optional.of(this.barbeariaCadastroConverter.applyResponse(barbeariaRepository.findById(id).get()));
    }

    public BarbeariaCadastroResponse createBarbearia(final BarbeariaCadastroRequest barbearia) {
        return this.barbeariaCadastroConverter.applyResponse(
                barbeariaRepository.save(
                        this.barbeariaCadastroConverter.apply(barbearia)
                )
        );
    }

    public void deleteBarbearia(Long id) {
        barbeariaRepository.deleteById(id);
    }
}


