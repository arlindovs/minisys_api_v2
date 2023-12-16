package com.learning.api.minisys.repositories.financeiro.titulo;

import com.learning.api.minisys.entitys.financeiro.titulo.TituloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepository extends JpaRepository<TituloEntity, Long> {
}
