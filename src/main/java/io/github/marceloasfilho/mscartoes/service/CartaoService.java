package io.github.marceloasfilho.mscartoes.service;

import io.github.marceloasfilho.mscartoes.entity.Cartao;

import java.util.List;

public interface CartaoService {
    void salvarCartao(Cartao cartao);

    List<Cartao> obterCartoesRendaMenorIgual(Long renda);

}
