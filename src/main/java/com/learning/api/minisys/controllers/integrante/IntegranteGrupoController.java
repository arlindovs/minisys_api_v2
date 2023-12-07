package com.learning.api.minisys.controllers.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteGrupoDto;
import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.repositories.IntegranteGrupoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/integrante_grupos")
public class IntegranteGrupoController {

    @Autowired
    private IntegranteGrupoRepository integranteGrupoRepository;

    @PostMapping
    @Transactional
    public void cadastrarIntegranteGrupo(@RequestBody @Valid IntegranteGrupoDto integranteGrupoDto) {
        integranteGrupoRepository.save(new IntegranteGrupoEntity(integranteGrupoDto));
    }

    @GetMapping
    public Iterable<IntegranteGrupoDto> listarIntegranteGrupos() {
        return integranteGrupoRepository.findAll().stream().map(IntegranteGrupoDto::new).toList();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizarIntegranteGrupo(@RequestBody @Valid IntegranteGrupoDto integranteGrupoDto) {

        if(!StringUtils.hasText(integranteGrupoDto.guid())) {
            throw new IllegalArgumentException("GUID não informado");
        }

        this.integranteGrupoRepository.findByGuid(integranteGrupoDto.guid()).ifPresentOrElse(integranteGrupoEntity -> {
            integranteGrupoEntity.atualizarIntegranteGrupo(integranteGrupoDto);
            this.integranteGrupoRepository.save(integranteGrupoEntity);
        }, () -> {
            throw new IllegalArgumentException("GUID não encontrado");
        });

        return ResponseEntity.noContent().build();

    }
}
