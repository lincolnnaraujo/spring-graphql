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
public class ProdutoInput {

    private String descricao;

    private BigDecimal valor;

    private Integer quantidade;

}
