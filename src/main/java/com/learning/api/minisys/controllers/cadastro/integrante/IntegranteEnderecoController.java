package com.learning.api.minisys.controllers.cadastro.integrante;

import com.learning.api.minisys.dtos.cadastro.integrante.IntegranteEnderecoDto;
import com.learning.api.minisys.dtos.cadastro.integrante.IntegranteGrupoDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEnderecoEntity;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteEnderecoRepository;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        IntegranteEnderecoEntity integranteEnderecoEntity = new IntegranteEnderecoEntity(integranteEnderecoDto);

        if(integranteEnderecoDto.integrante() != null) {
            Optional<IntegranteEntity> integranteEntity = integranteRepository.findById(integranteEnderecoDto.integrante().getCODIGO());

            if(integranteEntity.isPresent()) {
                integranteEnderecoEntity.setIntegrante(integranteEntity.get());
            }
        }

        integranteEnderecoRepository.save(integranteEnderecoEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<IntegranteEnderecoDto> listarIntegranteEnderecos() {
        return integranteEnderecoRepository.findAll().stream().map(IntegranteEnderecoDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<IntegranteEnderecoDto> buscarIntegranteEndereco(Long CODIGO) {
        var integranteEndereco = integranteEnderecoRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new IntegranteEnderecoDto(integranteEndereco));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<IntegranteEnderecoDto> atualizarIntegranteEndereco(@RequestBody @Valid IntegranteEnderecoDto integranteEnderecoDto) {
        IntegranteEnderecoEntity integranteEndereco = integranteEnderecoRepository.findById(integranteEnderecoDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Integrante Endereço não encontrado"));

        integranteEndereco.atualizarIntegranteEndereco(integranteEnderecoDto);

        if(integranteEnderecoDto.integrante() != null) {
            Optional<IntegranteEntity> integranteEntity = integranteRepository.findById(integranteEnderecoDto.integrante().getCODIGO());

            if(integranteEntity.isPresent()) {
                integranteEndereco.setIntegrante(integranteEntity.get());
            } else {
                RuntimeException e = new RuntimeException("Integrante não encontrado");
            }
        } else {
            integranteEndereco.setIntegrante(null);
        }

        integranteEnderecoRepository.save(integranteEndereco);

        return ResponseEntity.ok(new IntegranteEnderecoDto(integranteEndereco));
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<IntegranteEnderecoDto> deletarIntegranteEndereco(Long CODIGO) {
        var integranteEndereco = integranteEnderecoRepository.getReferenceById(CODIGO);

        integranteEnderecoRepository.deleteById(CODIGO);

        return ResponseEntity.ok(new IntegranteEnderecoDto(integranteEndereco));
    }
}
