package com.learning.api.minisys.repositories;

import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteGrupoRepository extends JpaRepository<IntegranteGrupoEntity, String> {
}
