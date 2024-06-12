package br.com.barber.shop.service;

import br.com.barber.shop.entity.Servico;
import br.com.barber.shop.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }
    public Optional<Servico> findAll(Long id) {
        return servicoRepository.findById(id);
    }
    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void deleteById(Long id) {
        servicoRepository.deleteById(id);
    }

    public ResponseEntity<Servico> findById(Long id) {

        return null;
    }
}
