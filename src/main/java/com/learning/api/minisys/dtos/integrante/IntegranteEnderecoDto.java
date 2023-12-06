package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteEnderecoEntity;
import com.learning.api.minisys.enums.integrante.TipoEndereco;
import com.learning.api.minisys.enums.integrante.TipoLogradouro;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record IntegranteEnderecoDto(

        String guid,

        IntegranteGuidDto integrante,

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
        this(integranteEnderecoEntity.getGuid(),
                new IntegranteGuidDto(integranteEnderecoEntity.getIntegrante()),
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