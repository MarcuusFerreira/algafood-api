package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    public Estado buscar(Long id) {
        return estadoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format("Estado com id %d não encontrada", id))
        );
    }

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void remover(Long id) {
        try {
            estadoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de estado com código %d", id));
        } catch (DataIntegrityViolationException exception) {
            throw new EntidadeEmUsoException(String.format("Estado de codigo %d não pode ser removida, pois está em uso", id));
        }
    }

}
