package io.github.marceloasfilho.mscartoes.service;

import io.github.marceloasfilho.mscartoes.entity.Cartao;
import io.github.marceloasfilho.mscartoes.repository.CartaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoServiceImpl implements CartaoService {
    private final CartaoRepository cartaoRepository;

    public CartaoServiceImpl(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @Override
    public void salvarCartao(Cartao cartao) {
        this.cartaoRepository.save(cartao);
    }

    @Override
    public List<Cartao> obterCartoesRendaMenorIgual(Long renda) {
        return this.cartaoRepository.findByRendaLessThanEqual(BigDecimal.valueOf(renda));
    }
}
