package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public List<Restaurante> listar() {
        return restauranteRepository.findAll();
    }

    public Restaurante buscar(Long restauranteId) {
       return restauranteRepository.findById(restauranteId).orElseThrow(
               () ->new EntidadeNaoEncontradaException(String.format("Restaurante de Id %d não foi encontrada", restauranteId))
       );
    }

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(
                        () -> new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com código %d", cozinhaId))
                );
        restaurante.setCozinha(cozinha);
        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> buscarPorTaxaFreteEntre(BigDecimal taxaMinima, BigDecimal taxaMaxima) {
        return restauranteRepository.findByTaxaFreteBetween(taxaMinima, taxaMaxima);
    }

    public List<Restaurante> buscarPorNome(String nome, Long cozinhaId) {
        return restauranteRepository.consultarPorNome(nome, cozinhaId);
    }
}
