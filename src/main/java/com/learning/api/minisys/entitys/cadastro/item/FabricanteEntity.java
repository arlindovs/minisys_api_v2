package com.learning.api.minisys.entitys.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.FabricanteDto;
import com.learning.api.minisys.dtos.cadastro.item.NewFabricanteDto;
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
@Table(name = "fabricante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteEntity {

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


    public FabricanteEntity(FabricanteDto fabricanteDto) {
        this.descricao = fabricanteDto.descricao();
        this.status = Status.ATIVO;
        this.empresa = fabricanteDto.empresa();
        this.versao = LocalDateTime.now();
    }

    public FabricanteEntity(NewFabricanteDto newFabricanteDto) {}

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
