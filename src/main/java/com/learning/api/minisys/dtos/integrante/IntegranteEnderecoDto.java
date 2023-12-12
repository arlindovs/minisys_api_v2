package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteEnderecoEntity;
import com.learning.api.minisys.enums.integrante.TipoEndereco;
import com.learning.api.minisys.enums.integrante.TipoLogradouro;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record IntegranteEnderecoDto(

        Long CODIGO,

        IntegranteDto integrante,

        @Enumerated
        TipoEndereco type,

        String stateRegistration,

        String cep,

        @Enumerated
        TipoLogradouro addressType,

        String address,

        int number,

        String complement,

        String district,

        String city,

        String state,

        LocalDateTime version
) {

    public IntegranteEnderecoDto(IntegranteEnderecoEntity integranteEnderecoEntity) {
        this(integranteEnderecoEntity.getCODIGO(),
                integranteEnderecoEntity.getIntegrante() != null ? new IntegranteDto(integranteEnderecoEntity.getIntegrante()) : null,
                integranteEnderecoEntity.getType(),
                integranteEnderecoEntity.getStateRegistration(),
                integranteEnderecoEntity.getCep(),
                integranteEnderecoEntity.getAddressType(),
                integranteEnderecoEntity.getAddress(),
                integranteEnderecoEntity.getNumber(),
                integranteEnderecoEntity.getComplement(),
                integranteEnderecoEntity.getDistrict(),
                integranteEnderecoEntity.getCity(),
                integranteEnderecoEntity.getState(),
                integranteEnderecoEntity.getVersion());
    }
}
