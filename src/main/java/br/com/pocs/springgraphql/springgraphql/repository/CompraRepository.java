package br.com.pocs.springgraphql.springgraphql.repository;

import br.com.pocs.springgraphql.springgraphql.model.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, UUID> {
}
