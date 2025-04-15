package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public List<Cozinha> listar() {
        return cozinhaRepository.findAll();
    }

    public Cozinha buscar(Long id) {
        return cozinhaRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Cozinha com id %d não foi encontrada", id))
        );
    }

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public  void excluir(Long cozinhaId) {
        try {
            cozinhaRepository.deleteById(cozinhaId);
        } catch (EmptyResultDataAccessException exception) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
        } catch (DataIntegrityViolationException exception) {
            throw new EntidadeEmUsoException(String.format("Cozinha de codigo %d não pode ser removida, pois está em uso", cozinhaId));
        }
    }

    public List<Cozinha> buscarPorNome(String nome) {
        return cozinhaRepository.findByNomeContaining(nome);
    }
}
