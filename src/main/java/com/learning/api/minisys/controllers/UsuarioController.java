package com.learning.api.minisys.controllers;

import com.learning.api.minisys.dtos.UsuarioDto;
import com.learning.api.minisys.entitys.usuario.UsuarioEntity;
import com.learning.api.minisys.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        usuarioRepository.save(new UsuarioEntity(usuarioDto));
    }

    @GetMapping
    public Iterable<UsuarioDto> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(UsuarioDto::new).toList();
    }
}
