package io.github.noltim.localizacao;

import io.github.noltim.localizacao.service.CidadeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    private CidadeService cidadeService;

    public LocalizacaoApplication(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @Override
    public void run(String... args) throws Exception {

        cidadeService.listarCidadesByNomeSpecs();
    }



    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

}
