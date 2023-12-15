package com.learning.api.minisys.repositories.cadastro.usuario;

import com.learning.api.minisys.entitys.cadastro.usuario.UsuarioGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioGrupoRepository extends JpaRepository<UsuarioGrupoEntity, Long> {
}
