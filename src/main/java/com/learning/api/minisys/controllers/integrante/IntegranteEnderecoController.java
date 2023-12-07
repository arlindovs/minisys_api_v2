package com.learning.api.minisys.controllers.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteEnderecoDto;
import com.learning.api.minisys.entitys.integrante.IntegranteEnderecoEntity;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.repositories.IntegranteEnderecoRepository;
import com.learning.api.minisys.repositories.IntegranteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/integrante_enderecos")
public class IntegranteEnderecoController {

    @Autowired
    private IntegranteEnderecoRepository integranteEnderecoRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarIntegranteEndereco(@RequestBody @Valid IntegranteEnderecoDto integranteEnderecoDto) {
        Optional<IntegranteEntity> integranteEntity = integranteRepository.findByGuid(integranteEnderecoDto.integrante().guid());

        if(integranteEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Integrante not found with the provided GUID");
        }

        IntegranteEnderecoEntity integranteEnderecoEntity = new IntegranteEnderecoEntity(integranteEnderecoDto);
        integranteEnderecoEntity.setIntegrante(integranteEntity.get());
        integranteEnderecoRepository.save(integranteEnderecoEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<IntegranteEnderecoDto> listarIntegranteEnderecos() {
        return integranteEnderecoRepository.findAll().stream().map(IntegranteEnderecoDto::new).toList();
    }
}
