package br.com.pocs.springgraphql.springgraphql.graphimpl;

import br.com.pocs.springgraphql.springgraphql.dto.ProdutoInput;
import br.com.pocs.springgraphql.springgraphql.model.ProdutoEntity;
import br.com.pocs.springgraphql.springgraphql.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ProdutoService produtoService;

    public ProdutoEntity getProduto(final String id){
        return produtoService.findById(UUID.fromString(id));
    }

    public List<ProdutoEntity> getProdutos(){
        return produtoService.findAll();
    }

    @Transactional
    public ProdutoEntity saveProduto(final ProdutoInput input){
        ProdutoEntity entity = new ProdutoEntity();
        entity.setDescricao(input.getDescricao());
        entity.setValor(input.getValor());
        entity.setQuantidade(input.getQuantidade());

        return produtoService.save(entity);
    }

    @Transactional
    public boolean deleteProduto(final String id){
        return produtoService.deleteById(UUID.fromString(id));
    }

}
