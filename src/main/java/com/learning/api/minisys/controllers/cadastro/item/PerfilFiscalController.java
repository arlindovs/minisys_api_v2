package com.learning.api.minisys.controllers.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.PerfilFiscalDto;
import com.learning.api.minisys.entitys.cadastro.item.PerfilFiscalEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.item.PerfilFiscalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/perfil_fiscal")
public class PerfilFiscalController {

    @Autowired
    private PerfilFiscalRepository perfilFiscalRepository;

    @PostMapping
    @Transactional
    public void cadastrarPerfilFiscal(@RequestBody @Valid PerfilFiscalDto perfilFiscalDto) {
        perfilFiscalRepository.save(new PerfilFiscalEntity(perfilFiscalDto));
    }

    @GetMapping
    public Iterable<PerfilFiscalDto> listarPerfilFiscal() {
        return perfilFiscalRepository.findAll().stream().map(PerfilFiscalDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<PerfilFiscalDto> buscarPerfilFiscal(@PathVariable Long CODIGO) {
        var perfilFiscal = perfilFiscalRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new PerfilFiscalDto(perfilFiscal));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PerfilFiscalDto> atualizarPerfilFiscal(@RequestBody @Valid PerfilFiscalDto perfilFiscalDto) {
        var perfilFiscal = perfilFiscalRepository.getReferenceById(perfilFiscalDto.CODIGO());
        perfilFiscal.atualizarPerfilFiscal(perfilFiscalDto);

        return ResponseEntity.ok(new PerfilFiscalDto(perfilFiscal));
    }

    @PostMapping("/ativar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> ativarPerfilFiscal(@PathVariable Long CODIGO) {
        var perfilFiscal = perfilFiscalRepository.getReferenceById(CODIGO);

        if (perfilFiscal.getStatus().equals(Status.ATIVO)) {
            perfilFiscal.setStatusInativo();
        } else {
            perfilFiscal.setStatusAtivo();
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarPerfilFiscal(@PathVariable Long CODIGO) {
        perfilFiscalRepository.deleteById(CODIGO);

        return ResponseEntity.ok().build();
    }
}
