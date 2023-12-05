package com.learning.api.minisys.controllers.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.repositories.IntegranteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/integrantes")
public class IntegranteController {

    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    @Transactional
    public void cadastrarIntegrante(@RequestBody @Valid IntegranteDto integranteDto) {
        integranteRepository.save(new IntegranteEntity(integranteDto));
    }

    @GetMapping
    public Iterable<IntegranteDto> listarIntegrantes() {
        return integranteRepository.findAll().stream().map(IntegranteDto::new).toList();
    }

}
