package br.com.pocs.springgraphql.springgraphql.service;

import br.com.pocs.springgraphql.springgraphql.model.ClienteEntity;
import br.com.pocs.springgraphql.springgraphql.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteEntity findById(final UUID id){
        final var cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public List<ClienteEntity> findAll(){
        return clienteRepository.findAll();
    }

    @Transactional
    public ClienteEntity save(final ClienteEntity entity){
        return clienteRepository.save(entity);
    }

    @Transactional
    public boolean deleteById(final UUID id){
        if (clienteRepository.findById(id).isPresent()){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
