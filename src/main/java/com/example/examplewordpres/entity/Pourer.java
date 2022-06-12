package com.example.examplewordpres.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Pourer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//

    private Integer number;//  №
    private String nameCastings;//Наименование отливки
    private String kolform;//Кол-во форм
    private Integer balls;//Кол-во отливок
    private String weightPcs;//Масса 1 шт
    private Integer generalMassa;//масса общий
    private Integer temperaFills;//Тем-ра Заливки
    private String note;//Примечание
}
