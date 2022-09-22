package io.github.marceloasfilho.mscartoes.entity;

import io.github.marceloasfilho.mscartoes.enums.BandeiraCartaoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private BandeiraCartaoEnum bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao(String nome, BandeiraCartaoEnum bandeira, BigDecimal renda, BigDecimal limite) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limite = limite;
    }
}
