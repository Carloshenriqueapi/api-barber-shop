package br.com.barber.shop.service;

import br.com.barber.shop.entity.BarbeariaCadastro;
import br.com.barber.shop.repository.BarbeariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeariaService {
    @Autowired
    private BarbeariaRepository barbeariaRepository;

    public List<BarbeariaCadastro> getAllBarbearia() {
        return barbeariaRepository.findAll();
    }

    public Optional<BarbeariaCadastro> getBarbeariaById(Long id) {
        return barbeariaRepository.findById(id);
    }

    public BarbeariaCadastro createBarbearia(BarbeariaCadastro barbearia) {
        return barbeariaRepository.save(barbearia);
    }

    public void deleteBarbearia(Long id) {
        barbeariaRepository.deleteById(id);
    }
}


