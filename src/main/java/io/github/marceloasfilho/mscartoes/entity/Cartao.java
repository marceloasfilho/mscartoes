package io.github.marceloasfilho.mscartoes.entity;

import io.github.marceloasfilho.mscartoes.enums.BandeiraCartaoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private BandeiraCartaoEnum bandeira;
    private BigDecimal renda;
    private BigDecimal limite;
}
