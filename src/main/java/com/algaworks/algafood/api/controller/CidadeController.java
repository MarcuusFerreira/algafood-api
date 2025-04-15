package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.service.CadastroCidadesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("cidades")
public class CidadeController {

    @Autowired
    private CadastroCidadesService cadastroCidadesService;

    @GetMapping
    public ResponseEntity<List<Cidade>> listar() {
        return ResponseEntity.ok(cadastroCidadesService.listar());
    }

    @GetMapping("{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
        try {
            Cidade cidade = cadastroCidadesService.buscar(cidadeId);
            return ResponseEntity.ok(cidade);
        } catch (EntidadeNaoEncontradaException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade) {
        cidade = cadastroCidadesService.salvar(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
    }

    @PutMapping("{cidadeId}")
    public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
        Cidade cidadeAtual = cadastroCidadesService.buscar(cidadeId);
        if (isNull(cidadeAtual)) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(cidade, cidadeAtual, "id");
        cidadeAtual = cadastroCidadesService.salvar(cidadeAtual);
        return ResponseEntity.ok(cidadeAtual);
    }

    @DeleteMapping("{cidadeId}")
    public ResponseEntity<CidadeController> responseEntity(@PathVariable Long cidadeId) {
        try {
            cadastroCidadesService.excluir(cidadeId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
