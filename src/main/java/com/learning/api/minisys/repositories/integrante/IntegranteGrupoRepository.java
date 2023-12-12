package com.learning.api.minisys.repositories.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntegranteGrupoRepository extends JpaRepository<IntegranteGrupoEntity, Long> {

}
