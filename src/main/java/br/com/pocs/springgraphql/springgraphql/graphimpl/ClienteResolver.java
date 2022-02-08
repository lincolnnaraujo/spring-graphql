package br.com.pocs.springgraphql.springgraphql.graphimpl;

import br.com.pocs.springgraphql.springgraphql.model.ClienteEntity;
import br.com.pocs.springgraphql.springgraphql.model.CompraEntity;
import br.com.pocs.springgraphql.springgraphql.service.CompraService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteResolver implements GraphQLResolver<ClienteEntity> {

    private final CompraService compraService;

    public List<CompraEntity> compras(ClienteEntity clienteEntity){
        return compraService.findAllByClienteEntity(clienteEntity);
    }

}
