package com.learning.api.minisys.repositories.cadastro.integrante;

import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteRepository extends JpaRepository<IntegranteEntity, Long> {

}
