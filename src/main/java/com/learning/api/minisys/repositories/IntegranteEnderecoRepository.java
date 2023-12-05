package com.learning.api.minisys.repositories;

import com.learning.api.minisys.entitys.integrante.IntegranteEnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteEnderecoRepository extends JpaRepository<IntegranteEnderecoEntity, String> {
}
