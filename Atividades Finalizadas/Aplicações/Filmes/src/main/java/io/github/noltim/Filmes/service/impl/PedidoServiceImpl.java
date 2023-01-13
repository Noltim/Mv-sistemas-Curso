package io.github.noltim.Filmes.service.impl;

import io.github.noltim.Filmes.domain.entity.Cliente;
import io.github.noltim.Filmes.domain.entity.Filmes;
import io.github.noltim.Filmes.domain.entity.ItemPedido;
import io.github.noltim.Filmes.domain.entity.Pedido;
import io.github.noltim.Filmes.domain.repository.ClienteRepository;
import io.github.noltim.Filmes.domain.repository.FilmesRepository;
import io.github.noltim.Filmes.domain.repository.ItemPedidoRepository;
import io.github.noltim.Filmes.domain.repository.PedidoRepository;
import io.github.noltim.Filmes.exception.RegraNegocioException;
import io.github.noltim.Filmes.rest.dto.ItemPedidoDTO;
import io.github.noltim.Filmes.rest.dto.PedidoDTO;
import io.github.noltim.Filmes.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {


    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final FilmesRepository filmesRepository;



    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemsPedido = converterItems(pedido, dto.getItems());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);
        return pedido;

    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não é possivel realizar um pedido sem item.");
        }
        return items
                .stream()
                .map(dto -> {
            Integer idFilme = dto.getFilme();
            Filmes filme = filmesRepository
                    .findById(idFilme)
                    .orElseThrow(() -> new RegraNegocioException("Código do filme inválido"));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setFilme(filme);
            return itemPedido;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidoRepository.findByIdFetchItens(id);
    }


}
