package io.github.noltim.localizacao;

import io.github.noltim.localizacao.domain.entity.Cidade;
import io.github.noltim.localizacao.domain.repository.CidadeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    private CidadeRepository cidadeRepository;

    public LocalizacaoApplication(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        listarCidade();
    }

    @Transactional
    void salvarCidade() {
        var cidade = new Cidade(1L, "São Paulo", 12349555L);
        cidadeRepository.save(cidade);
    }

    @Transactional
    void listarCidade() {
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

}
