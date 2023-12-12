package com.learning.api.minisys.controllers.usuario;

import com.learning.api.minisys.dtos.usuario.UsuarioDto;
import com.learning.api.minisys.repositories.integrante.IntegranteRepository;
import com.learning.api.minisys.repositories.usuario.UsuarioGrupoRepository;
import com.learning.api.minisys.repositories.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private UsuarioGrupoRepository usuarioGrupoRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {;
    }

    @GetMapping
    public Iterable<UsuarioDto> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(UsuarioDto::new).toList();
    }

}
