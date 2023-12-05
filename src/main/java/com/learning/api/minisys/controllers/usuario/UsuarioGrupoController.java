package com.learning.api.minisys.controllers.usuario;

import com.learning.api.minisys.dtos.usuario.UsuarioGrupoDto;
import com.learning.api.minisys.entitys.usuario.UsuarioGrupoEntity;
import com.learning.api.minisys.repositories.UsuarioGrupoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
