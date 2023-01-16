package io.github.noltim.Filmes.domain.entity;

import io.github.noltim.Filmes.domain.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "filme")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "{campo.titulo.obrigatorio}")
    private String titulo;
    @NotNull(message = "{campo.ano.obrigatorio}")
    private Integer ano;
    @NotEmpty(message = "{campo.duracao.obrigatorio}")
    private String duracao;
    @NotEmpty(message = "{campo.sinopse.obrigatorio}")
    private String sinopse;

    @Enumerated(EnumType.STRING)
    private Genero genero;
    @NotNull(message = "{campo.preco.obrigatorio}")
    private BigDecimal preco;
    private LocalDate dataRegistro;



}
