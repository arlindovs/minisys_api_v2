package com.learning.api.minisys.controllers.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteEnderecoDto;
import com.learning.api.minisys.entitys.integrante.IntegranteEnderecoEntity;
import com.learning.api.minisys.repositories.IntegranteEnderecoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/integrante_enderecos")
public class IntegranteEnderecoController {

    @Autowired
    private IntegranteEnderecoRepository integranteEnderecoRepository;

    @PostMapping
    @Transactional
    public void cadastrarIntegranteEndereco(@RequestBody @Valid IntegranteEnderecoDto integranteEnderecoDto) {
        integranteEnderecoRepository.save(new IntegranteEnderecoEntity(integranteEnderecoDto));
    }

    @GetMapping
    public Iterable<IntegranteEnderecoDto> listarIntegranteEnderecos() {
        return integranteEnderecoRepository.findAll().stream().map(IntegranteEnderecoDto::new).toList();
    }
}
