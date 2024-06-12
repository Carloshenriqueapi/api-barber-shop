package br.com.barber.shop.service;

import br.com.barber.shop.entity.Profissional;
import br.com.barber.shop.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public List<Profissional> getAllProfissionais() {
        return profissionalRepository.findAll();
    }

    public Optional<Profissional> getProfissionalById(Long id) {
        return profissionalRepository.findById(id);
    }

    public Profissional createProfissional(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    public void deleteProfissional(Long id) {
        profissionalRepository.deleteById(id);
    }
}


