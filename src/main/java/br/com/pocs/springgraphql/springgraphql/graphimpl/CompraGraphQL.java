package br.com.pocs.springgraphql.springgraphql.graphimpl;

import br.com.pocs.springgraphql.springgraphql.dto.CompraInput;
import br.com.pocs.springgraphql.springgraphql.model.CompraEntity;
import br.com.pocs.springgraphql.springgraphql.service.ClienteService;
import br.com.pocs.springgraphql.springgraphql.service.CompraService;
import br.com.pocs.springgraphql.springgraphql.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final CompraService compraService;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public CompraEntity getCompra(final String id){
        return compraService.findById(UUID.fromString(id));
    }

    public List<CompraEntity> getCompras(){
        return compraService.findAll();
    }

    @Transactional
    public CompraEntity saveCompra(final CompraInput input){
        CompraEntity entity = new CompraEntity();
        entity.setValor(input.getValor());
        entity.setStatus(input.getStatus());
        entity.setDataHora(LocalDateTime.now());
        entity.setClienteEntity(clienteService.findById(UUID.fromString(input.getClienteId())));
        entity.setProdutoEntity(produtoService.findById(UUID.fromString(input.getProdutoId())));

        return compraService.save(entity);
    }

    @Transactional
    public boolean deleteCompra(final String id){
        return compraService.deleteById(UUID.fromString(id));
    }

}
