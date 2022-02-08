package br.com.pocs.springgraphql.springgraphql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraInput {

    private BigDecimal valor;

    private String status;

    private String clienteId;

    private String produtoId;
}
