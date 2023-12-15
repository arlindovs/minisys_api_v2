package com.learning.api.minisys.repositories.cadastro.item;

import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
