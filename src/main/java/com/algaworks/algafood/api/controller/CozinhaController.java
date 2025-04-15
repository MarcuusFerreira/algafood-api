package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    @GetMapping
    public List<Cozinha> listar() {
        return cadastroCozinhaService.listar();
    }

    @GetMapping("por-nome")
    public List<Cozinha> buscarPorNome(@RequestParam String nome) {

        return cadastroCozinhaService.buscarPorNome(nome);
    }

    @GetMapping("{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
        try {
            Cozinha cozinha = cadastroCozinhaService.buscar(cozinhaId);
            return ResponseEntity.ok(cozinha);
        } catch (EntidadeNaoEncontradaException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cozinha> salvar(@RequestBody Cozinha cozinha) {
        Cozinha cozinhaSalva = cadastroCozinhaService.salvar(cozinha);
        return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaSalva);
    }

    @PutMapping("{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
        try {
            Cozinha cozinhaAtual = cadastroCozinhaService.buscar(cozinhaId);
            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
            Cozinha cozinhaSalva = cadastroCozinhaService.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaSalva);
        } catch (EntidadeNaoEncontradaException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
        try {
            cadastroCozinhaService.excluir(cozinhaId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeEmUsoException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntidadeNaoEncontradaException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
