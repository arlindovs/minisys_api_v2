package com.learning.api.minisys.enums.usuario;

public enum Role {

    SUPER("Super"),
    ADMIN("Administrador"),
    USER("Usuário");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
