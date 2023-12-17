package com.learning.api.minisys.entitys.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.ItemGrupoDto;
import com.learning.api.minisys.dtos.cadastro.item.NewItemGrupoDto;
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
@Table(name = "item_grupo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemGrupoEntity extends BaseEntity {

    @Column(name = "DESCRICAO", unique = true)
    private String descricao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;

    public ItemGrupoEntity(ItemGrupoDto itemGrupoDto) {
        this.descricao = itemGrupoDto.descricao();
        this.status = Status.ATIVO;
        this.empresa = itemGrupoDto.empresa();
        this.versao = LocalDateTime.now();
    }

    public ItemGrupoEntity(NewItemGrupoDto newItemGrupoDto) {
        super();
    }

    public void atualizarItemGrupo(ItemGrupoDto itemGrupoDto) {
        if(itemGrupoDto.descricao() != null) {
            this.descricao = itemGrupoDto.descricao();
        }
        if(itemGrupoDto.empresa() != null) {
            this.empresa = itemGrupoDto.empresa();
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
