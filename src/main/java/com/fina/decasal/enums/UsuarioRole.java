package com.fina.decasal.enums;

public enum UsuarioRole {

    MARIDO("marido"),
    ESPOSA("esposa");

    private String role;

    UsuarioRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}


