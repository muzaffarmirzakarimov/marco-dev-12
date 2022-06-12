package com.example.examplewordpres.entity.enums;

import lombok.AllArgsConstructor;


public enum RoleEnum {
    DIRECTOR("direktor"),WORKER("worker"),LABARANT("labarant");

    private String name;


    RoleEnum(String name) {
        this.name=name;
    }
}
