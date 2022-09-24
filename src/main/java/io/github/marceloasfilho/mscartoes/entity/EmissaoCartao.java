package io.github.marceloasfilho.mscartoes.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmissaoCartao {
    private Long idCartao;
    private String cpf;
    private String endereco;
    private BigDecimal limiteLiberado;
}