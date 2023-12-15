package com.learning.api.minisys.entitys.item;

import com.learning.api.minisys.dtos.item.FabricanteDto;
import com.learning.api.minisys.dtos.item.NewFabricanteDto;
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
@Table(name = "fabricante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteEntity extends BaseEntity {

    @Column(name = "DESCRICAO", unique = true)
    private String descricao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public FabricanteEntity(FabricanteDto fabricanteDto) {
        this.descricao = fabricanteDto.descricao();
        this.status = fabricanteDto.status();
        this.empresa = fabricanteDto.empresa();
        this.versao = fabricanteDto.versao();
    }

    public FabricanteEntity(NewFabricanteDto newFabricanteDto) {
        super();
    }

    public void atualizarFabricante(FabricanteDto fabricanteDto) {
        if(fabricanteDto.descricao() != null) {
            this.descricao = fabricanteDto.descricao();
        }
        if(fabricanteDto.status() != null) {
            this.status = fabricanteDto.status();
        }
        if(fabricanteDto.empresa() != null) {
            this.empresa = fabricanteDto.empresa();
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
