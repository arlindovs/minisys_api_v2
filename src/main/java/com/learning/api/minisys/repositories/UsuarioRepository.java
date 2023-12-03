package com.learning.api.minisys.repositories;

import com.learning.api.minisys.entitys.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
