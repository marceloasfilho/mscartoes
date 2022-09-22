package io.github.marceloasfilho.mscartoes.dto;

import io.github.marceloasfilho.mscartoes.entity.Cartao;
import io.github.marceloasfilho.mscartoes.enums.BandeiraCartaoEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoDTO {
    private String nome;
    private BandeiraCartaoEnum bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(this.nome, this.bandeira, this.renda, this.limite);
    }
}
