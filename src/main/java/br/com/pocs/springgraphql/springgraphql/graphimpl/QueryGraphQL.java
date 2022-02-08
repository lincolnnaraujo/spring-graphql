package br.com.pocs.springgraphql.springgraphql.graphimpl;

import br.com.pocs.springgraphql.springgraphql.model.ClienteEntity;
import br.com.pocs.springgraphql.springgraphql.repository.ClienteRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class QueryGraphQL implements GraphQLQueryResolver {

    private final ClienteRepository clienteRepository;

    public ClienteEntity getCliente(final String id){
        final var cliente = clienteRepository.findById(UUID.fromString(id));
        return cliente.orElse(null);
    }

    public List<ClienteEntity> getClientes(){
        return clienteRepository.findAll();
    }

}
