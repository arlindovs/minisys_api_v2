package com.learning.api.minisys.entitys.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.dtos.integrante.IntegranteEnderecoDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.integrante.TipoEndereco;
import com.learning.api.minisys.enums.integrante.TipoLogradouro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "integrante_endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteEnderecoEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "INTEGRANTE")
    private IntegranteEntity integrante;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoEndereco type;

    @Column(name = "INSCRICAO_ESTADUAL")
    private String stateRegistration;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "TIPO_LOGRADOURO")
    @Enumerated(EnumType.STRING)
    private TipoLogradouro addressType;

    @Column(name = "LOGRADOURO")
    private String address;

    @Column(name = "NUMERO")
    private int number;

    @Column(name = "COMPLEMENTO")
    private String complement;

    @Column(name = "BAIRRO")
    private String district;

    @Column(name = "MUNICIPIO")
    private String city;

    @Column(name = "UF")
    private String state;

    @Column(name = "VERSAO")
    private LocalDateTime version;


    public IntegranteEnderecoEntity(IntegranteEnderecoDto integranteEnderecoDto) {
        super();

        this.integrante = new IntegranteEntity(integranteEnderecoDto.integrante());
        this.type = integranteEnderecoDto.type();
        this.stateRegistration = integranteEnderecoDto.stateRegistration();
        this.cep = integranteEnderecoDto.cep();
        this.addressType = integranteEnderecoDto.addressType();
        this.address = integranteEnderecoDto.address();
        this.number = integranteEnderecoDto.number();
        this.complement = integranteEnderecoDto.complement();
        this.district = integranteEnderecoDto.district();
        this.city = integranteEnderecoDto.city();
        this.state = integranteEnderecoDto.state();
        this.version = LocalDateTime.now();
    }
}
