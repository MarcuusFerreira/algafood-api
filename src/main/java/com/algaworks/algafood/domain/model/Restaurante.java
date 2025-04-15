package com.algaworks.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinha;

    @Column(nullable = false)
    private BigDecimal taxaFrete;

    @Column(nullable = false)
    private boolean ativo;

    @Column(nullable = false)
    private boolean aberto;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    private LocalDateTime dataAtualizacao;

}
