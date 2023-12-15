package com.learning.api.minisys.entitys.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.NewUnidadeMedidaDto;
import com.learning.api.minisys.dtos.cadastro.item.UnidadeMedidaDto;
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
@Table(name = "unidade_medida")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeMedidaEntity extends BaseEntity {

    @Column(name = "DESCRICAO", unique = true)
    private String descricao;

    @Column(name = "SIMBOLO", unique = true)
    private String simbolo;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public UnidadeMedidaEntity(UnidadeMedidaDto unidadeMedidaDto) {
        this.descricao = unidadeMedidaDto.descricao();
        this.simbolo = unidadeMedidaDto.simbolo();
        this.status = unidadeMedidaDto.status();
        this.empresa = unidadeMedidaDto.empresa();
        this.versao = unidadeMedidaDto.versao();
    }

    public UnidadeMedidaEntity(NewUnidadeMedidaDto newUnidadeMedidaDto) {
        super();
    }

    public void atualizarUnidadeMedida(UnidadeMedidaDto unidadeMedidaDto) {
        if(unidadeMedidaDto.descricao() != null) {
            this.descricao = unidadeMedidaDto.descricao();
        }
        if(unidadeMedidaDto.simbolo() != null) {
            this.simbolo = unidadeMedidaDto.simbolo();
        }
        if(unidadeMedidaDto.status() != null) {
            this.status = unidadeMedidaDto.status();
        }
        if(unidadeMedidaDto.empresa() != null) {
            this.empresa = unidadeMedidaDto.empresa();
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
