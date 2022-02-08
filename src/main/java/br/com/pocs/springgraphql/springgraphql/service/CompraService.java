package br.com.pocs.springgraphql.springgraphql.service;

import br.com.pocs.springgraphql.springgraphql.model.ClienteEntity;
import br.com.pocs.springgraphql.springgraphql.model.CompraEntity;
import br.com.pocs.springgraphql.springgraphql.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;

    public CompraEntity findById(final UUID id){
        final var compra = compraRepository.findById(id);
        return compra.orElse(null);
    }

    public List<CompraEntity> findAll(){
        return compraRepository.findAll();
    }

    @Transactional
    public CompraEntity save(final CompraEntity entity){
        return compraRepository.save(entity);
    }

    @Transactional
    public boolean deleteById(final UUID id){
        if (compraRepository.findById(id).isPresent()){
            compraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<CompraEntity> findAllByClienteEntity(ClienteEntity clienteEntity){
        return compraRepository.findAllByClienteEntity(clienteEntity);
    }

}
