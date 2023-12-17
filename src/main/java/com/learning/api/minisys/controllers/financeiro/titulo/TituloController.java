package com.learning.api.minisys.controllers.financeiro.titulo;

import com.learning.api.minisys.dtos.financeiro.titulo.TituloDto;
import com.learning.api.minisys.entitys.financeiro.titulo.TituloEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteRepository;
import com.learning.api.minisys.repositories.financeiro.titulo.TituloRepository;
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
@RequestMapping("/api/v1/titulos")
public class TituloController {

    @Autowired
    private TituloRepository tituloRepository;
    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarTitulo(@RequestBody @Valid TituloDto tituloDto) {
        TituloEntity titulo = new TituloEntity(tituloDto);

        if (tituloDto.integrante() != null) {
            integranteRepository.findById(tituloDto.integrante().getCODIGO())
                    .ifPresent(titulo::setIntegrante);
        }

        if (tituloDto.funcionario() != null) {
            integranteRepository.findById(tituloDto.funcionario().getCODIGO())
                    .ifPresent(titulo::setFuncionario);
        }

        tituloRepository.save(titulo);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<TituloDto> listarTitulos() {
        return tituloRepository.findAll().stream().map(TituloDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<TituloDto> buscarTitulo(Long CODIGO) {
        var titulo = tituloRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new TituloDto(titulo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TituloDto> atualizarTitulo(@RequestBody @Valid TituloDto tituloDto) {
        TituloEntity titulo = tituloRepository.findById(tituloDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Titulo não encontrado"));

        titulo.atualizarTitulo(tituloDto);

        if(tituloDto.integrante() != null) {
            integranteRepository.findById(tituloDto.integrante().getCODIGO())
                    .ifPresent(titulo::setIntegrante);
        } else {
            titulo.setIntegrante(null);
        }

        if(tituloDto.funcionario() != null) {
            integranteRepository.findById(tituloDto.funcionario().getCODIGO())
                    .ifPresent(titulo::setFuncionario);
        } else {
            titulo.setFuncionario(null);
        }

        tituloRepository.save(titulo);

        return ResponseEntity.ok(new TituloDto(titulo));
    }

    @PostMapping("/cancelar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> cancelarTitulo(@PathVariable Long CODIGO) {
        var titulo = tituloRepository.getReferenceById(CODIGO);

        if (titulo.getStatus().equals(Status.NORMAL)) {
            titulo.setStatusCancelado();
        } else {
            titulo.setStatusNormal();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarTitulo(@PathVariable Long CODIGO) {
        tituloRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
