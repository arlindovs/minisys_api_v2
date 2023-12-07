package com.learning.api.minisys.controllers.usuario;

import com.learning.api.minisys.dtos.usuario.UsuarioDto;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.usuario.UsuarioEntity;
import com.learning.api.minisys.entitys.usuario.UsuarioGrupoEntity;
import com.learning.api.minisys.repositories.IntegranteRepository;
import com.learning.api.minisys.repositories.UsuarioGrupoRepository;
import com.learning.api.minisys.repositories.UsuarioRepository;
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
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        Optional<UsuarioGrupoEntity> usuarioGrupoEntity = usuarioGrupoRepository.findByGuid(usuarioDto.usuarioGrupo().guid());
        Optional<IntegranteEntity> integranteEntity = integranteRepository.findByGuid(usuarioDto.funcionario().guid());

        if(usuarioGrupoEntity.isEmpty() || integranteEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário Grupo GUID não encontrado");
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDto);
        usuarioEntity.setUsuarioGrupo(usuarioGrupoEntity.get());
        usuarioEntity.setFuncionario(integranteEntity.get());
        usuarioRepository.save(usuarioEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<UsuarioDto> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(UsuarioDto::new).toList();
    }

}
