package io.github.noltim.Filmes.domain.entity;

import io.github.noltim.Filmes.domain.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String titulo;
    private Integer ano;
    private String duracao;
    private String sinopse;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private BigDecimal preco;
    private LocalDate dataRegistro;



}
