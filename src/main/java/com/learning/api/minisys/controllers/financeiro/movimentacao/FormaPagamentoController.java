package com.learning.api.minisys.controllers.financeiro.movimentacao;

import com.learning.api.minisys.dtos.financeiro.movimentacao.FormaPagamentoDto;
import com.learning.api.minisys.entitys.financeiro.movimentacao.FormaPagamentoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.financeiro.movimentacao.FormaPagamentoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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

@RestController
@RequestMapping("/api/v1/formas_pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarFormaPagamento(@RequestBody @Valid FormaPagamentoDto formaPagamentoDto) {
        FormaPagamentoEntity formaPagamento = new FormaPagamentoEntity(formaPagamentoDto);

        formaPagamentoRepository.save(formaPagamento);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<FormaPagamentoDto> listarFormasPagamento() {
        return formaPagamentoRepository.findAll().stream().map(FormaPagamentoDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<FormaPagamentoDto> buscarFormaPagamento(Long CODIGO) {
        var formaPagamento = formaPagamentoRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new FormaPagamentoDto(formaPagamento));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<FormaPagamentoDto> atualizarFormaPagamento(@RequestBody @Valid FormaPagamentoDto formaPagamentoDto) {
        FormaPagamentoEntity formaPagamento = formaPagamentoRepository.findById(formaPagamentoDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));

        formaPagamento.atualizarFormaPagamento(formaPagamentoDto);

        return ResponseEntity.ok(new FormaPagamentoDto(formaPagamento));
    }

    @PostMapping("/ativar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> ativarFormaPagamento(@PathVariable Long CODIGO) {
        var formaPagamento = formaPagamentoRepository.getReferenceById(CODIGO);

        if (formaPagamento.getStatus().equals(Status.ATIVO)) {
            formaPagamento.setStatusInativo();
        } else {
            formaPagamento.setStatusAtivo();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarFormaPagamento(@PathVariable Long CODIGO) {
        formaPagamentoRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
