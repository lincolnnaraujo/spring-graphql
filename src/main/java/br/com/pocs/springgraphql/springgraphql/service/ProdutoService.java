package br.com.pocs.springgraphql.springgraphql.service;

import br.com.pocs.springgraphql.springgraphql.model.ProdutoEntity;
import br.com.pocs.springgraphql.springgraphql.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoEntity findById(final UUID id){
        final var produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public List<ProdutoEntity> findAll(){
        return produtoRepository.findAll();
    }

    @Transactional
    public ProdutoEntity save(final ProdutoEntity entity){
        return produtoRepository.save(entity);
    }

    @Transactional
    public boolean deleteById(final UUID id){
        if (produtoRepository.findById(id).isPresent()){
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
