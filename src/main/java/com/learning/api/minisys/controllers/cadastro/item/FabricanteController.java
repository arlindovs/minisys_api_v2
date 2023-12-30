package com.learning.api.minisys.controllers.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.FabricanteDto;
import com.learning.api.minisys.entitys.cadastro.item.FabricanteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.item.FabricanteRepository;
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
@RequestMapping("/api/v1/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @PostMapping
    @Transactional
    public void cadastrarFabricante(@RequestBody @Valid FabricanteDto fabricanteDto) {
        fabricanteRepository.save(new FabricanteEntity(fabricanteDto));
    }

    @GetMapping
    public Iterable<FabricanteDto> listarFabricantes() {
        return fabricanteRepository.findAll().stream().map(FabricanteDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<FabricanteDto> buscarFabricante(@PathVariable Long CODIGO) {
        var fabricante = fabricanteRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new FabricanteDto(fabricante));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<FabricanteDto> atualizarFabricante(@RequestBody @Valid FabricanteDto fabricanteDto) {
        var fabricante = fabricanteRepository.getReferenceById(fabricanteDto.CODIGO());
        fabricante.atualizarFabricante(fabricanteDto);

        return ResponseEntity.ok(new FabricanteDto(fabricante));
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<FabricanteDto> desativarFabricante(@PathVariable Long CODIGO) {
        var fabricante = fabricanteRepository.getReferenceById(CODIGO);

        if (fabricante.getStatus().equals(Status.ATIVO)) {
            fabricante.setStatusInativo();
        } else {
            fabricante.setStatusAtivo();
        }

        return ResponseEntity.ok(new FabricanteDto(fabricante));
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarFabricante(@PathVariable Long CODIGO) {
        fabricanteRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
