package io.github.noltim.Filmes.domain.repository;

import io.github.noltim.Filmes.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
