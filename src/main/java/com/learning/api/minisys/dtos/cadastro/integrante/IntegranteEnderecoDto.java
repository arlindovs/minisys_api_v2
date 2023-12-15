package com.learning.api.minisys.dtos.cadastro.integrante;

import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEnderecoEntity;
import com.learning.api.minisys.enums.integrante.TipoEndereco;
import com.learning.api.minisys.enums.integrante.TipoLogradouro;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record IntegranteEnderecoDto(

        Long CODIGO,

        NewIntegranteDto integrante,

        @Enumerated
        TipoEndereco tipo,

        String inscricaoEstadual,

        String cep,

        @Enumerated
        TipoLogradouro tipoLogradouro,

        String logradouro,

        int numero,

        String complemento,

        String bairro,

        String municipio,

        String estado,

        LocalDateTime versao
) {

    public IntegranteEnderecoDto(IntegranteEnderecoEntity integranteEnderecoEntity) {
        this(integranteEnderecoEntity.getCODIGO(),
                integranteEnderecoEntity.getIntegrante() != null ?
                        new NewIntegranteDto(integranteEnderecoEntity.getIntegrante().getCODIGO()) : null,
                integranteEnderecoEntity.getTipo(),
                integranteEnderecoEntity.getInscricaoEstadual(),
                integranteEnderecoEntity.getCep(),
                integranteEnderecoEntity.getTipoLogradouro(),
                integranteEnderecoEntity.getLogradouro(),
                integranteEnderecoEntity.getNumero(),
                integranteEnderecoEntity.getComplemento(),
                integranteEnderecoEntity.getBairro(),
                integranteEnderecoEntity.getMunicipio(),
                integranteEnderecoEntity.getEstado(),
                integranteEnderecoEntity.getVersao());
    }
}
