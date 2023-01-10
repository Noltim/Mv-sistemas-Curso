package io.github.noltim.localizacao.service;

import io.github.noltim.localizacao.domain.entity.Cidade;
import io.github.noltim.localizacao.domain.repository.CidadeRepository;

import static io.github.noltim.localizacao.domain.repository.specs.CidadeSpecs.*;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public void listarCidadePorNomeLike() {
        cidadeRepository.findByNomeLike("%São%").forEach(System.out::println);
    }

    @Transactional
    public void listarCidade() {
        cidadeRepository.findAll().forEach(System.out::println);
    }

    @Transactional
    public void listarCidadePorNome() {
        cidadeRepository.findByNome("São Paulo").forEach(System.out::println);
    }

    @Transactional
    public void listarCidadePorNomeComecandoPor() {
        cidadeRepository.findByNomeStartingWith("São").forEach(System.out::println);
    }

    @Transactional
    public void listarCidadePorNomeTerminandoPor() {
        cidadeRepository.findByNomeEndingWith("neiro").forEach(System.out::println);
    }


    public void listarCidadePorNomeContendo() {
        cidadeRepository.findByNomeContaining("P").forEach(System.out::println);
    }


    public void listarCidadePorHabitantes() {
        cidadeRepository.findByHabitantes(10000000L).forEach(System.out::println);
    }


    public void salvarCidade() {
        var cidade = new Cidade(1L, "São Paulo", 12349555L);
        cidadeRepository.save(cidade);
    }

    public void listarCidadesByNomeSpecs() {
        cidadeRepository
                .findAll(nomeEqual("São Paulo").and(habitantesGreaterThan(1000L)))
                .forEach(System.out::println);
    }
}
