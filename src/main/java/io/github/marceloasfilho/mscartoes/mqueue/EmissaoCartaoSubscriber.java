package io.github.marceloasfilho.mscartoes.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marceloasfilho.mscartoes.entity.Cartao;
import io.github.marceloasfilho.mscartoes.entity.CartaoCliente;
import io.github.marceloasfilho.mscartoes.entity.EmissaoCartao;
import io.github.marceloasfilho.mscartoes.repository.CartaoClienteRepository;
import io.github.marceloasfilho.mscartoes.repository.CartaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;
    private final CartaoClienteRepository cartaoClienteRepository;

    @RabbitListener(queues = "${queue.name.mscartoes-emissao-cartao}")
    public void receberSolicitacaoEmissao(@Payload String payload) {
        ObjectMapper mapper;
        try {
            mapper = new ObjectMapper();
            EmissaoCartao emissaoCartao = mapper.readValue(payload, EmissaoCartao.class);

            Cartao cartao = this.cartaoRepository.findById(emissaoCartao.getIdCartao()).orElseThrow();

            CartaoCliente cartaoCliente = new CartaoCliente();
            cartaoCliente.setCpf(emissaoCartao.getCpf());
            cartaoCliente.setCartao(cartao);
            cartaoCliente.setLimite(emissaoCartao.getLimiteLiberado());

            this.cartaoClienteRepository.save(cartaoCliente);

        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
    }
}
