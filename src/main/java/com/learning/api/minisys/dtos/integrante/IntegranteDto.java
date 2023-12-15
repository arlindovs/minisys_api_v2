package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.integrante.TipoDocumento;
import com.learning.api.minisys.enums.integrante.TipoIntegrante;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record IntegranteDto(

        Long CODIGO,

        NewIntegranteGrupoDto integranteGrupo,

        @Enumerated
        TipoIntegrante tipoIntegrante,

        String nome,

        String segundoNome,

        String telefone,

        String email,

        TipoDocumento tipoDocumento,

        String documento,

        LocalDateTime dataCriacao,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,

        LocalDateTime versao
) {

    public IntegranteDto(IntegranteEntity integranteEntity) {
        this(integranteEntity.getCODIGO(),
                integranteEntity.getIntegranteGrupo() != null ?
                        new NewIntegranteGrupoDto(integranteEntity.getIntegranteGrupo().getCODIGO()) : null,
                integranteEntity.getTipoIntegrante(),
                integranteEntity.getNome(),
                integranteEntity.getSegundoNome(),
                integranteEntity.getTelefone(),
                integranteEntity.getEmail(),
                integranteEntity.getTipoDocumento(),
                integranteEntity.getDocumento(),
                integranteEntity.getDataCriacao(),
                integranteEntity.getStatus(),
                integranteEntity.getEmpresa(),
                integranteEntity.getVersao());
    }
}
