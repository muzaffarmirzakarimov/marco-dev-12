package com.example.examplewordpres.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer total; //всего
    private Integer slag;  //шлак
    private Integer byskachShlag;//ПО скач шлак
    private Float additivesFeMn;//Присадки FeMn
    private Integer massaFeMn; //Масса FeMn
    private Float additivesFeSi;// Присадки FeSi
    private Integer massaFeSi;  //Масса FeSi
    private Integer fev;
    private Integer al;
    private Integer feP;
    private Integer siCa;

    private Integer tempBegin;//температура металл начола

    private Integer tempEnd;//температура металл конес


    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime timeBegin;//Время выпуска металла начола

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime timeEnd;//Время выпуска металла конес

    private String remarks;//Замичения по ходу плавки
    private boolean active=true;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TestProba> probas;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TestLadle> ladles;






}
