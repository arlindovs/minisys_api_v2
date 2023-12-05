package com.learning.api.minisys.enums.integrante;

/**
 * Enumeração que representa os tipos de logradouro.
 * Cada tipo de logradouro é representado por uma string de descrição.
 */
public enum TipoLogradouro {

    RUA("Rua"),
    AVENIDA("Avenida"),
    TRAVESSA("Travessa"),
    ALAMEDA("Alameda"),
    ESTRADA("Estrada"),
    RODOVIA("Rodovia"),
    PRACA("Praça"),
    LARGO("Largo"),
    BECO("Beco"),
    VIADUTO("Viaduto"),
    JARDIM("Jardim"),
    PARQUE("Parque"),
    LOTEAMENTO("Loteamento"),
    CONDOMINIO("Condomínio"),
    CHACARA("Chácara"),
    FAZENDA("Fazenda"),
    SITIO("Sítio"),
    VILA("Vila"),
    OUTROS("Outros");

    // Descrição do tipo de logradouro
    private String descricao;

    /**
     * Construtor do enum.
     * @param descricao A descrição do tipo de logradouro.
     */
    TipoLogradouro(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição do tipo de logradouro.
     * @return A descrição do tipo de logradouro.
     */
    public String descricao() {
        return this.descricao;
    }
}
