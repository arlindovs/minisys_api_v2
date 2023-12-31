package com.learning.api.minisys.controllers.cadastro.integrante;

import com.learning.api.minisys.dtos.cadastro.integrante.IntegranteGrupoDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteGrupoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/integrante_grupos")
public class IntegranteGrupoController {

    @Autowired
    private IntegranteGrupoRepository integranteGrupoRepository;

    @PostMapping
    @Transactional
    public void cadastrarIntegranteGrupo(@RequestBody @Valid IntegranteGrupoDto integranteGrupoDto) {
        integranteGrupoRepository.save(new IntegranteGrupoEntity(integranteGrupoDto));
    }

    @GetMapping
    public Iterable<IntegranteGrupoDto> listarIntegranteGrupos() {
        return integranteGrupoRepository.findAll().stream().map(IntegranteGrupoDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<IntegranteGrupoDto> buscarIntegranteGrupo(@PathVariable Long CODIGO) {
        var integranteGrupo = integranteGrupoRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new IntegranteGrupoDto(integranteGrupo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<IntegranteGrupoDto> atualizarIntegranteGrupo(@RequestBody @Valid IntegranteGrupoDto integranteGrupoDto) {
        var integranteGrupo = integranteGrupoRepository.getReferenceById(integranteGrupoDto.CODIGO());
        integranteGrupo.atualizarIntegranteGrupo(integranteGrupoDto);

        return ResponseEntity.ok(new IntegranteGrupoDto(integranteGrupo));
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarIntegranteGrupo(@PathVariable Long CODIGO) {
        integranteGrupoRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }

    /*
     *Final do controller de desativar é necessário acrescentar o response OK para que retorne no front-end
     * pois está sendo passado uma condição com o retorno de response.
     */
    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<IntegranteGrupoDto> ativarIntegranteGrupo(@PathVariable Long CODIGO) {
        var integranteGrupo = integranteGrupoRepository.getReferenceById(CODIGO);

        if (integranteGrupo.getStatus().equals(Status.ATIVO)) {
            integranteGrupo.setStatusInativo();
        } else {
            integranteGrupo.setStatusAtivo();
        }

        return ResponseEntity.ok(new IntegranteGrupoDto (integranteGrupo));
    }


}
