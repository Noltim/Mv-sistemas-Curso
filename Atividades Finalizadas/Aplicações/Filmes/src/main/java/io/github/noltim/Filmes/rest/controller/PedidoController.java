package io.github.noltim.Filmes.rest.controller;

import io.github.noltim.Filmes.domain.entity.ItemPedido;
import io.github.noltim.Filmes.domain.entity.Pedido;
import io.github.noltim.Filmes.rest.dto.InformacaoItemPedidoDTO;
import io.github.noltim.Filmes.rest.dto.InformacoesPedidoDTO;
import io.github.noltim.Filmes.rest.dto.PedidoDTO;
import io.github.noltim.Filmes.service.PedidoService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = pedidoService.salvar(dto);
        return pedido.getId();
    }

//    @GetMapping("{id}")
//    public InformacoesPedidoDTO getById(@PathVariable Integer id){
//        return pedidoService
//                .obterPedidoCompleto(id)
//                .map(pedido -> converter(pedido))
//                .orElseThrow(()->
//                        new ResponseStatusException(NOT_FOUND, "Pedido não encontrado!"));
//    }

    private InformacoesPedidoDTO converter(Pedido pedido){
        return InformacoesPedidoDTO
                .builder()
                .codigo(pedido.getId())
                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(pedido.getCliente().getCpf())
                .nomeCliente(pedido.getCliente().getNome())
                .total(pedido.getTotal())
                .status(pedido.getStatus().name())
                .items(converter(pedido.getItems()))
                .build();
    }

    private List<InformacaoItemPedidoDTO> converter(List<ItemPedido> itens){
        if(CollectionUtils.isEmpty(itens)){
            return Collections.emptyList();
        }
        return itens
                .stream()
                .map(item -> InformacaoItemPedidoDTO
                        .builder()
                        .descricaoProduto(item.getFilme().getSinopse())
                        .precoUnitario(item.getFilme().getPreco())
                        .quantidade(item.getQuantidade())
                        .build()
        ).collect(Collectors.toList());
    }

}
