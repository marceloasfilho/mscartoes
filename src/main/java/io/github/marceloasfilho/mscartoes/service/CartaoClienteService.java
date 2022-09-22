package io.github.marceloasfilho.mscartoes.service;

import io.github.marceloasfilho.mscartoes.entity.CartaoCliente;

import java.util.List;

public interface CartaoClienteService {
    List<CartaoCliente> obterCartoesPorCpf(String cpf);
}
