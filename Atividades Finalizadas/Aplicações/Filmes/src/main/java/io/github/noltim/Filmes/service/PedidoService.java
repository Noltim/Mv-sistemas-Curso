package io.github.noltim.Filmes.service;

import io.github.noltim.Filmes.domain.entity.Cliente;
import io.github.noltim.Filmes.domain.entity.Pedido;
import io.github.noltim.Filmes.domain.enums.StatusPedido;
import io.github.noltim.Filmes.rest.dto.InformacoesPedidoDTO;
import io.github.noltim.Filmes.rest.dto.PedidoDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);

    InformacoesPedidoDTO obterPedidos();

}
