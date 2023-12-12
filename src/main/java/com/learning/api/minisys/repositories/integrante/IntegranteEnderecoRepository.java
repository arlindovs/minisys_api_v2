package com.learning.api.minisys.repositories.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteEnderecoEntity;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntegranteEnderecoRepository extends JpaRepository<IntegranteEnderecoEntity, Long> {
}
