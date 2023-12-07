package com.learning.api.minisys.repositories;

import com.learning.api.minisys.entitys.usuario.UsuarioGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioGrupoRepository extends JpaRepository<UsuarioGrupoEntity, String> {

    Optional<UsuarioGrupoEntity> findByGuid(String guid);
}
