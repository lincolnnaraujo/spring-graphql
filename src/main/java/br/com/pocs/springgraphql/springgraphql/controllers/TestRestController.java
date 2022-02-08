package br.com.pocs.springgraphql.springgraphql.controllers;

import br.com.pocs.springgraphql.springgraphql.model.ClienteEntity;
import br.com.pocs.springgraphql.springgraphql.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/")
public class TestRestController {

    private final ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteEntity>> getClientes(){

        final var clientes = clienteRepository.findAll();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteEntity> getCliente(@PathVariable("id") final String id){

        final var cliente = clienteRepository.findById(UUID.fromString(id));

        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.of(Optional.empty()));
    }

}