package com.learning.api.minisys.controllers.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.repositories.IntegranteGrupoRepository;
import com.learning.api.minisys.repositories.IntegranteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/integrantes")
public class IntegranteController {

    @Autowired
    private IntegranteRepository integranteRepository;

    @Autowired
    private IntegranteGrupoRepository integranteGrupoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarIntegrante(@RequestBody @Valid IntegranteDto integranteDto) {
        Optional<IntegranteGrupoEntity> integranteGrupoEntity = integranteGrupoRepository.findByGuid(integranteDto.integranteGrupo().guid());

        if (integranteGrupoEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IntegranteGrupo not found with the provided GUID");
        }

        IntegranteEntity integranteEntity = new IntegranteEntity(integranteDto);
        integranteEntity.setIntegranteGrupo(integranteGrupoEntity.get());
        integranteRepository.save(integranteEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<IntegranteDto> listarIntegrantes() {
        return integranteRepository.findAll().stream().map(IntegranteDto::new).toList();
    }

}