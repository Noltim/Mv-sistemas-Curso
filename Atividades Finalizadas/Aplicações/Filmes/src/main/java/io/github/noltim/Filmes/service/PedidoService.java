package io.github.noltim.Filmes.service;

import io.github.noltim.Filmes.domain.entity.Pedido;
import io.github.noltim.Filmes.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

//    Optional<Pedido> obterPedidoCompleto(Integer id);
}
