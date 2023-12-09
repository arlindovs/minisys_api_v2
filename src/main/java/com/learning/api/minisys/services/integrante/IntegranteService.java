package com.learning.api.minisys.services.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.repositories.integrante.IntegranteGrupoRepository;
import com.learning.api.minisys.repositories.integrante.IntegranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IntegranteService {

    @Autowired
    private IntegranteRepository integranteRepository;

    @Autowired
    private IntegranteGrupoRepository integranteGrupoRepository;

    @Transactional
    public IntegranteDto updateIntegrante(String guid, IntegranteDto integranteDto) {
        IntegranteEntity integranteEntity = integranteRepository.findByGuid(guid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Integrante não encontrado"));

        if (integranteDto.integranteGrupo() != null) {
            IntegranteGrupoEntity integranteGrupoEntity = integranteGrupoRepository.findByGuid(integranteDto.integranteGrupo().guid())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "IntegranteGrupo não encontrado"));

            integranteEntity.setIntegranteGrupo(integranteGrupoEntity);
        }

        // Chama o método atualizarIntegrante no IntegranteEntity existente com o IntegranteDto como argumento
        integranteEntity.atualizarIntegrante(integranteDto);

        integranteRepository.save(integranteEntity);

        return new IntegranteDto(integranteEntity);
    }
}
