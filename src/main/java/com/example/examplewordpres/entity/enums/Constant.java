package com.example.examplewordpres.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Constant {

    ЗАВАЛКА("Завалка"),ПЛАВЛЕНИЕ("Плавление"),КИПЕНИЕ("Кипение"), СКАЧИВШЛАК("Скачившлак");
    private String name;
}
