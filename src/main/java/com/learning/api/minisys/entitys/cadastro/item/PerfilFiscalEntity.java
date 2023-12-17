package com.learning.api.minisys.entitys.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.NewPerfilFiscalDto;
import com.learning.api.minisys.dtos.cadastro.item.PerfilFiscalDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "perfil_fiscal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilFiscalEntity extends BaseEntity {

    @Column(name = "DESCRICAO", unique = true)
    private String descricao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public PerfilFiscalEntity(PerfilFiscalDto perfilFiscalDto) {
        this.descricao = perfilFiscalDto.descricao();
        this.empresa = perfilFiscalDto.empresa();
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public PerfilFiscalEntity(NewPerfilFiscalDto newPerfilFiscalDto) {
        super();
    }

    public void atualizarPerfilFiscal(PerfilFiscalDto perfilFiscalDto) {
        if(perfilFiscalDto.descricao() != null) {
            this.descricao = perfilFiscalDto.descricao();
        }
        if(perfilFiscalDto.empresa() != null) {
            this.empresa = perfilFiscalDto.empresa();
        }
            this.versao = LocalDateTime.now();
    }

    public void setStatusAtivo() {
        this.status = Status.ATIVO;
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
    }
}
