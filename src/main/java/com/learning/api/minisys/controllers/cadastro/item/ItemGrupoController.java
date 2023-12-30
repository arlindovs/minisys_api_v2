package com.learning.api.minisys.controllers.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.ItemGrupoDto;
import com.learning.api.minisys.entitys.cadastro.item.ItemGrupoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.item.ItemGrupoRepository;
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
@RequestMapping("/api/v1/item_grupos")
public class ItemGrupoController {

    @Autowired
    private ItemGrupoRepository itemGrupoRepository;

    @PostMapping
    @Transactional
    public void cadastrarItemGrupo(@RequestBody @Valid ItemGrupoDto itemGrupoDto) {
        itemGrupoRepository.save(new ItemGrupoEntity(itemGrupoDto));
    }

    @GetMapping
    public Iterable<ItemGrupoDto> listarItemGrupos() {
        return itemGrupoRepository.findAll().stream().map(ItemGrupoDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<ItemGrupoDto> buscarItemGrupo(@PathVariable Long CODIGO) {
        var itemGrupo = itemGrupoRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new ItemGrupoDto(itemGrupo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ItemGrupoDto> atualizarItemGrupo(@RequestBody @Valid ItemGrupoDto itemGrupoDto) {
        var itemGrupo = itemGrupoRepository.getReferenceById(itemGrupoDto.CODIGO());
        itemGrupo.atualizarItemGrupo(itemGrupoDto);

        return ResponseEntity.ok(new ItemGrupoDto(itemGrupo));
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<ItemGrupoDto> desativarItemGrupo(@PathVariable Long CODIGO) {
        var itemGrupo = itemGrupoRepository.getReferenceById(CODIGO);

        if (itemGrupo.getStatus().equals(Status.ATIVO)) {
            itemGrupo.setStatusInativo();
        } else {
            itemGrupo.setStatusAtivo();
        }

        return ResponseEntity.ok(new ItemGrupoDto(itemGrupo));
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarItemGrupo(@PathVariable Long CODIGO) {
        itemGrupoRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
