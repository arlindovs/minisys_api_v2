package com.learning.api.minisys.repositories.cadastro.integrante;

import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteGrupoRepository extends JpaRepository<IntegranteGrupoEntity, Long> {

}
