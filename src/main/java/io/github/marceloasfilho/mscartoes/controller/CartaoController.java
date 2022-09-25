package io.github.marceloasfilho.mscartoes.controller;

import io.github.marceloasfilho.mscartoes.dto.CartaoClienteDTO;
import io.github.marceloasfilho.mscartoes.dto.CartaoDTO;
import io.github.marceloasfilho.mscartoes.entity.Cartao;
import io.github.marceloasfilho.mscartoes.entity.CartaoCliente;
import io.github.marceloasfilho.mscartoes.service.CartaoClienteService;
import io.github.marceloasfilho.mscartoes.service.CartaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/cartoes")
@Slf4j
public class CartaoController {

    public final CartaoService cartaoService;
    public final CartaoClienteService cartaoClienteService;

    public CartaoController(CartaoService cartaoService, CartaoClienteService cartaoClienteService) {
        this.cartaoService = cartaoService;
        this.cartaoClienteService = cartaoClienteService;
    }

    @GetMapping(path = "/status")
    public void status() {
        log.info("Status MSCARTOES");
    }

    @PostMapping(path = "/salvar")
    @Transactional
    public ResponseEntity<Cartao> salvar(@RequestBody CartaoDTO cartaoDTO) {
        Cartao cartao = cartaoDTO.toModel();
        this.cartaoService.salvarCartao(cartao);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/renda")
    public ResponseEntity<List<Cartao>> obterCartoesRendaMenorIgual(@RequestParam("renda") Long renda) {
        List<Cartao> cartoes = this.cartaoService.obterCartoesRendaMenorIgual(renda);

        if (cartoes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cartoes, HttpStatus.OK);
    }

    @GetMapping(path = "/cpf", params = "cpf")
    public ResponseEntity<List<CartaoClienteDTO>> obterCartoesPorCpf(@RequestParam("cpf") String cpf){
        List<CartaoCliente> cartaoClientes = this.cartaoClienteService.obterCartoesPorCpf(cpf);
        List<CartaoClienteDTO> result = cartaoClientes
                .stream()
                .map(c -> CartaoClienteDTO
                        .builder()
                        .nome(c.getCartao().getNome())
                        .bandeira(c.getCartao().getBandeira().toString())
                        .limite(c.getLimite())
                        .build()).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
