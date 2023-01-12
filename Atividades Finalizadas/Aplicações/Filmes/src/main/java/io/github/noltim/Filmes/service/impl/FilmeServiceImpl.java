package io.github.noltim.Filmes.service.impl;

import io.github.noltim.Filmes.domain.repository.FilmesRepository;
import io.github.noltim.Filmes.service.FilmesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmeServiceImpl implements FilmesService {

    private FilmesRepository filmesRepository;

}
