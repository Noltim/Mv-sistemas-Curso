package io.github.noltim.Filmes.rest.controller;

import io.github.noltim.Filmes.domain.entity.Filmes;
import io.github.noltim.Filmes.domain.repository.FilmesRepository;
import io.github.noltim.Filmes.service.FilmesService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/filmes")
public class FilmesController {

    private FilmesRepository filmesRepository;
    private FilmesService filmesService;

    public FilmesController(FilmesRepository filmesRepository, FilmesService filmesService) {
        this.filmesRepository = filmesRepository;
        this.filmesService = filmesService;
    }


    @GetMapping("{id}")
    public Filmes getFilmeById(@PathVariable Integer id) {
        return filmesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cliente não encontrado"));

    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Filmes save(@RequestBody Filmes filme) {
        filme.setDataRegistro(LocalDate.now());
        return filmesRepository.save(filme);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        filmesRepository
                .findById(id)
                .map(cliente ->
                {
                    filmesRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cliente não encontrado!"));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Filmes filme) {
        filmesRepository
                .findById(id)
                .map(filmeExistente -> {
                    filme.setId(filmeExistente.getId());
                    filmesRepository.save(filme);
                    return filmeExistente;
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cliente não encontrado na base de dados."));
    }

    @GetMapping
    public List<Filmes> find(Filmes filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return filmesRepository.findAll(example);


    }

}
