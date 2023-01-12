package io.github.noltim.Filmes.domain.repository;

import io.github.noltim.Filmes.domain.entity.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<Filmes, Integer> {
}
