package com.learning.api.minisys.entitys.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {


    @Column(name = "GUID", unique = true)
    private String guid;

    public BaseEntity() {
        this.guid = UUID.randomUUID().toString();
    }
}
