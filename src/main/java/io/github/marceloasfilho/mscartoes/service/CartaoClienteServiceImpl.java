package io.github.marceloasfilho.mscartoes.service;

import io.github.marceloasfilho.mscartoes.entity.CartaoCliente;
import io.github.marceloasfilho.mscartoes.repository.CartaoClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoClienteServiceImpl implements CartaoClienteService {
    private final CartaoClienteRepository cartaoClienteRepository;

    public CartaoClienteServiceImpl(CartaoClienteRepository cartaoClienteRepository) {
        this.cartaoClienteRepository = cartaoClienteRepository;
    }

    @Override
    public List<CartaoCliente> obterCartoesPorCpf(String cpf) {
        return this.cartaoClienteRepository.findByCpf(cpf);
    }
}