package br.com.barber.shop.infrastructure.converter;

import br.com.barber.shop.infrastructure.api.payload.request.ClienteRequest;
import br.com.barber.shop.infrastructure.api.payload.response.ClienteEnderecoResponse;
import br.com.barber.shop.infrastructure.api.payload.response.ClienteResponse;
import br.com.barber.shop.infrastructure.database.entity.Cliente;
import br.com.barber.shop.infrastructure.database.entity.ClienteEndereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ClienteConverter implements Function<ClienteRequest, Cliente> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Cliente apply(ClienteRequest clienteRequest) {
        return Cliente.builder()
                .nome(clienteRequest.nome())
                .sobreNome(clienteRequest.sobreNome())
                .cpf(clienteRequest.cpf())
                .rg(clienteRequest.rg())
                .endereco(
                        ClienteEndereco.builder()
                                .rua(clienteRequest.endereco().rua())
                                .bairro(clienteRequest.endereco().bairro())
                                .cidade(clienteRequest.endereco().cidade())
                                .cep(clienteRequest.endereco().cep())
                                .numeroResidencia(clienteRequest.endereco().numeroResidencia())
                                .uf(clienteRequest.endereco().uf())
                                .build()
                )
                .email(clienteRequest.email())
                .telefone(clienteRequest.telefone())
                .build();
    }

    public List<ClienteResponse> applyResponse(List<Cliente> list) {
        if (list != null && !list.isEmpty()) {
            return list.stream().map(cliente -> {
                return new ClienteResponse(
                        cliente.getNome(),
                        cliente.getSobreNome(),
                        cliente.getDataNascimento(),
                        cliente.getCpf(),
                        cliente.getRg(),
                        cliente.getSexo(),
                        cliente.getEmail(),
                        new ClienteEnderecoResponse(
                                cliente.getEndereco().getRua(),
                                cliente.getEndereco().getBairro(),
                                cliente.getEndereco().getCidade(),
                                cliente.getEndereco().getCep(),
                                cliente.getEndereco().getNumeroResidencia(),
                                cliente.getEndereco().getUf())
                );
            }).collect(Collectors.toList());
        }
        return null;
    }

    public ClienteResponse applyResponse(ClienteResponse cliente) {
        return new ClienteResponse(
                cliente.nome(),
                cliente.sobreNome(),
                cliente.dataNascimento(),
                cliente.cpf(),
                cliente.rg(),
                cliente.sexo(),
                cliente.email(),
                new ClienteEnderecoResponse(
                        cliente.endereco().rua(),
                        cliente.endereco().bairro(),
                        cliente.endereco().cidade(),
                        cliente.endereco().cep(),
                        cliente.endereco().numeroResidencia(),
                        cliente.endereco().uf())
        );
    }
}
