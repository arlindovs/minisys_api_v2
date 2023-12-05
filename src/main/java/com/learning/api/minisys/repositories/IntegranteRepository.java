package com.learning.api.minisys.repositories;

import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteRepository extends JpaRepository<IntegranteEntity, String> {
}
