package com.learning.api.minisys.repositories.item;

import com.learning.api.minisys.dtos.item.ItemGrupoDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemGrupoRepository extends JpaRepository<ItemGrupoDto, Long> {
}
