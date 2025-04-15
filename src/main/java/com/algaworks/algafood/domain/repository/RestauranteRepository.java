package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaMinima, BigDecimal taxaMaxima);

    @Query("from Restaurante  where nome like %:nome% and cozinha.id = :cozinhaId")
    List<Restaurante> consultarPorNome(String nome, Long cozinhaId);

//    List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinhaId);

}
