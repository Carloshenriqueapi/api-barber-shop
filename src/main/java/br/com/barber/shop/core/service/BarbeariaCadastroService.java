package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaCadastroRequest;
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

    public List<BarbeariaCadastro> getAllBarbearia() {
        return barbeariaRepository.findAll();
    }

    public Optional<BarbeariaCadastro> getBarbeariaById(Long id) {
        return barbeariaRepository.findById(id);
    }

    public BarbeariaCadastro createBarbearia(final BarbeariaCadastroRequest barbearia) {
        return barbeariaRepository.save(this.barbeariaCadastroConverter.apply(barbearia));
    }

    public void deleteBarbearia(Long id) {
        barbeariaRepository.deleteById(id);
    }
}


