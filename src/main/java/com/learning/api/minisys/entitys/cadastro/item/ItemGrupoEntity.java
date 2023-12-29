package com.learning.api.minisys.entitys.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.ItemGrupoDto;
import com.learning.api.minisys.dtos.cadastro.item.NewItemGrupoDto;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "item_grupo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemGrupoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

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

    public ItemGrupoEntity(NewItemGrupoDto newItemGrupoDto) {}

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
        this.versao = LocalDateTime.now();
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
        this.versao = LocalDateTime.now();
    }
}
