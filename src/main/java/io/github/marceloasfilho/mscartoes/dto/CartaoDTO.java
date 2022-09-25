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

    public Cartao toModel() {
        Cartao cartao = new Cartao();
        cartao.setBandeira(this.bandeira);
        cartao.setNome(this.nome);
        cartao.setRenda(this.renda);
        cartao.setLimite(this.limite);
        return cartao;
    }
}
