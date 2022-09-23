package io.github.marceloasfilho.mscartoes.dto;

import io.github.marceloasfilho.mscartoes.entity.CartaoCliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartaoClienteDTO {
    private String cpf;
    private String bandeira;
    private BigDecimal limite;

    public CartaoClienteDTO(CartaoCliente cartaoCliente) {
        this.cpf = cartaoCliente.getCpf();
        this.bandeira = cartaoCliente.getCartao().getBandeira().toString();
        this.limite = cartaoCliente.getLimite();
    }
}