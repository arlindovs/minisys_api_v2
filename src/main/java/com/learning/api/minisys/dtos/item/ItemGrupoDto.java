package com.learning.api.minisys.dtos.item;

import com.learning.api.minisys.entitys.item.ItemGrupoEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ItemGrupoDto(

        Long CODIGO,

        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,

        @Enumerated
        Status status,

        @NotBlank(message = "O campo empresa é obrigatório")
        Long empresa,

        LocalDateTime versao
) {

        public ItemGrupoDto(ItemGrupoEntity itemGrupoEntity) {
            this(itemGrupoEntity.getCODIGO(),
                    itemGrupoEntity.getDescricao(),
                    itemGrupoEntity.getStatus(),
                    itemGrupoEntity.getEmpresa(),
                    itemGrupoEntity.getVersao());
        }

}
