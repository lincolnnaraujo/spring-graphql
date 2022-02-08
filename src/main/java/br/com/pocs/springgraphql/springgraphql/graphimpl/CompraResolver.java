package br.com.pocs.springgraphql.springgraphql.graphimpl;

import br.com.pocs.springgraphql.springgraphql.model.ClienteEntity;
import br.com.pocs.springgraphql.springgraphql.model.CompraEntity;
import br.com.pocs.springgraphql.springgraphql.model.ProdutoEntity;
import br.com.pocs.springgraphql.springgraphql.service.ClienteService;
import br.com.pocs.springgraphql.springgraphql.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/** Resolver criado para conseguir usar fetch = Lazy e evitar consultas desnecessárias
 */
@Component
@RequiredArgsConstructor
public class CompraResolver implements GraphQLResolver<CompraEntity> {

    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public ClienteEntity cliente(CompraEntity compraEntity){
        return clienteService.findById(compraEntity.getClienteEntity().getId());
    }

    public ProdutoEntity produto(CompraEntity compraEntity){
        return produtoService.findById(compraEntity.getProdutoEntity().getId());
    }
}
