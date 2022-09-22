package io.github.marceloasfilho.mscartoes.repository;

import io.github.marceloasfilho.mscartoes.entity.CartaoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoClienteRepository extends JpaRepository<CartaoCliente, Long> {
    List<CartaoCliente> findByCpf(String cpf);
}
