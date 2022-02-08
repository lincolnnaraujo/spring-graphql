package br.com.pocs.springgraphql.springgraphql.repository;

import br.com.pocs.springgraphql.springgraphql.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
}
