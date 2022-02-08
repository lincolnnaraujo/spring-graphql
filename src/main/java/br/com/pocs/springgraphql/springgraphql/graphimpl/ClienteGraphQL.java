package br.com.pocs.springgraphql.springgraphql.graphimpl;

import br.com.pocs.springgraphql.springgraphql.dto.ClienteInput;
import br.com.pocs.springgraphql.springgraphql.model.ClienteEntity;
import br.com.pocs.springgraphql.springgraphql.service.ClienteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ClienteService clienteService;

    public ClienteEntity getCliente(final String id){
        return clienteService.findById(UUID.fromString(id));
    }

    public List<ClienteEntity> getClientes(){
        return clienteService.findAll();
    }

    @Transactional
    public ClienteEntity saveCliente(final ClienteInput input){
        ClienteEntity entity = new ClienteEntity();
        entity.setNome(input.getNome());
        entity.setCep(input.getCep());

        return clienteService.save(entity);
    }

    @Transactional
    public boolean deleteCliente(final String id){
        return clienteService.deleteById(UUID.fromString(id));
    }

}
