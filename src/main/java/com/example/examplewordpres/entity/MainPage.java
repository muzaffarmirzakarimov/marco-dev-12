package com.example.examplewordpres.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MainPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime localDateTime = LocalDateTime.now();


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate=LocalDate.now();

    private String smelter;//Плавильщик
    private String smeltingMaster;//Мастер плавку
    private String controllerOTK;//контроллер ОТК
    private String sectionManager;//Началник участка
    private boolean active=true;

    @OneToOne(cascade = CascadeType.PERSIST)
    private WorkerHomework workerHomework;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Laboratory laboratory;

    @OneToOne(cascade = CascadeType.PERSIST)
    private DetailDescription detailDescription;


}
