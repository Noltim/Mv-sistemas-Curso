package io.github.noltim.Filmes.rest;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;


public class ApiErros {

    @Getter
    private List<String> errors;

    public ApiErros(String mensagemErrors) {
        this.errors = Arrays.asList(mensagemErrors);
    }
}
