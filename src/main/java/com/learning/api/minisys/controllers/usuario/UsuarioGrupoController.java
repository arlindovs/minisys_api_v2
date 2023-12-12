package com.learning.api.minisys.controllers.usuario;

import com.learning.api.minisys.dtos.usuario.UsuarioGrupoDto;
import com.learning.api.minisys.entitys.usuario.UsuarioGrupoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.usuario.UsuarioGrupoRepository;
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
@RequestMapping("/api/v1/usuario_grupos")
public class UsuarioGrupoController {

    @Autowired
    private UsuarioGrupoRepository usuarioGrupoRepository;

    @PostMapping
    @Transactional
    public void cadastrarUsuarioGrupo(@RequestBody @Valid UsuarioGrupoDto usuarioGrupoDto) {
        usuarioGrupoRepository.save(new UsuarioGrupoEntity(usuarioGrupoDto));
    }

    @GetMapping
    public Iterable<UsuarioGrupoDto> listarUsuarioGrupos() {
        return usuarioGrupoRepository.findAll().stream().map(UsuarioGrupoDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<UsuarioGrupoDto> buscarUsuarioGrupo(@PathVariable Long CODIGO) {
        var usuarioGrupo = usuarioGrupoRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new UsuarioGrupoDto(usuarioGrupo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UsuarioGrupoDto> atualizarUsuarioGrupo(@RequestBody @Valid UsuarioGrupoDto usuarioGrupoDto) {
        var usuarioGrupo = usuarioGrupoRepository.getReferenceById(usuarioGrupoDto.CODIGO());
        usuarioGrupo.atualizarUsuarioGrupo(usuarioGrupoDto);

        return ResponseEntity.ok(new UsuarioGrupoDto(usuarioGrupo));
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarUsuarioGrupo(@PathVariable Long CODIGO) {
        usuarioGrupoRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/ativar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> ativarUsuarioGrupo(@PathVariable Long CODIGO) {
        var usuarioGrupo = usuarioGrupoRepository.getReferenceById(CODIGO);
        if(usuarioGrupo.getStatus().equals(Status.ATIVO)) {
            usuarioGrupo.setStatusInativo();
        }
        usuarioGrupo.setStatusAtivo();

        return ResponseEntity.noContent().build();
    }
}
