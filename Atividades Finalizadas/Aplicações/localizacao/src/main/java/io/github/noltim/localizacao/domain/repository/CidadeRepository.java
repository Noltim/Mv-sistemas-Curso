package io.github.noltim.localizacao.domain.repository;

import io.github.noltim.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
