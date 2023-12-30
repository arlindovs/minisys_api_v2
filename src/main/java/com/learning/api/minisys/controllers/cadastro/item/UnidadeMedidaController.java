package com.learning.api.minisys.controllers.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.UnidadeMedidaDto;
import com.learning.api.minisys.entitys.cadastro.item.UnidadeMedidaEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.item.UnidadeMedidaRepository;
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
@RequestMapping("/api/v1/unidade_medida")
public class UnidadeMedidaController {

    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    @PostMapping
    @Transactional
    public void cadastrarUnidadeMedida(@RequestBody @Valid UnidadeMedidaDto unidadeMedidaDto) {
        unidadeMedidaRepository.save(new UnidadeMedidaEntity(unidadeMedidaDto));
    }

    @GetMapping
    public Iterable<UnidadeMedidaDto> listarUnidadeMedida() {
        return unidadeMedidaRepository.findAll().stream().map(UnidadeMedidaDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<UnidadeMedidaDto> buscarUnidadeMedida(@PathVariable Long CODIGO) {
        var unidadeMedida = unidadeMedidaRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new UnidadeMedidaDto(unidadeMedida));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UnidadeMedidaDto> atualizarUnidadeMedida(@RequestBody @Valid UnidadeMedidaDto unidadeMedidaDto) {
        var unidadeMedida = unidadeMedidaRepository.getReferenceById(unidadeMedidaDto.CODIGO());
        unidadeMedida.atualizarUnidadeMedida(unidadeMedidaDto);

        return ResponseEntity.ok(new UnidadeMedidaDto(unidadeMedida));
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<UnidadeMedidaDto> desativarUnidadeMedida(@PathVariable Long CODIGO) {
        var unidadeMedida = unidadeMedidaRepository.getReferenceById(CODIGO);

        if (unidadeMedida.getStatus().equals(Status.ATIVO)) {
            unidadeMedida.setStatusInativo();
        } else {
            unidadeMedida.setStatusAtivo();
        }

        return ResponseEntity.ok(new UnidadeMedidaDto(unidadeMedida));
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarUnidadeMedida(@PathVariable Long CODIGO) {
        unidadeMedidaRepository.deleteById(CODIGO);

        return ResponseEntity.ok().build();
    }
}
