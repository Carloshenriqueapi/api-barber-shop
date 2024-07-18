package br.com.barber.shop.core.service;

import br.com.barber.shop.infrastructure.api.payload.request.BarbeariaAvaliacaoRequest;
import br.com.barber.shop.infrastructure.api.payload.response.BarbeariaAvaliacaoResponse;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaAvaliacao;
import br.com.barber.shop.infrastructure.database.entity.BarbeariaServico;
import br.com.barber.shop.infrastructure.database.entity.Cliente;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaAvaliacaoRepository;
import br.com.barber.shop.infrastructure.database.repository.BarbeariaServicoRepository;
import br.com.barber.shop.infrastructure.database.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class BarbeariaAvaliacaoService {

        private final BarbeariaAvaliacaoRepository avaliacaoRepository;
        private final ClienteRepository clienteRepository;
        private final BarbeariaServicoRepository servicoRepository;

        public BarbeariaAvaliacaoService(BarbeariaAvaliacaoRepository avaliacaoRepository,
                                         ClienteRepository clienteRepository,
                                         BarbeariaServicoRepository servicoRepository) {
            this.avaliacaoRepository = avaliacaoRepository;
            this.clienteRepository = clienteRepository;
            this.servicoRepository = servicoRepository;
        }

        public BarbeariaAvaliacaoResponse criarAvaliacao(BarbeariaAvaliacaoRequest request) {
            Cliente cliente = clienteRepository.findById(request.clienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            BarbeariaServico servico = servicoRepository.findById(request.servicoId())
                    .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

            BarbeariaAvaliacao avaliacao = new BarbeariaAvaliacao();
            avaliacao.setCliente(cliente);
            avaliacao.setServico(servico);
            avaliacao.setEstrelas(request.estrelas());
            avaliacao.setTexto(request.texto());

            avaliacao = avaliacaoRepository.save(avaliacao);

            return new BarbeariaAvaliacaoResponse(
                    avaliacao.getId(),
                    avaliacao.getCliente().getId(),
                    avaliacao.getServico().getId(),
                    avaliacao.getEstrelas(),
                    avaliacao.getTexto()
            );
        }
    }

