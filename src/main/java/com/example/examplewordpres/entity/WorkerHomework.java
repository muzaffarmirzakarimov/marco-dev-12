package com.example.examplewordpres.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class WorkerHomework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer bake;//Печь
    //    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fuse;//Плавка
    //  @Column(nullable = false)
    private LocalDateTime localDateTime = LocalDateTime.now();
    @Column(nullable = false)
    private String smelter;//Плавилщик

    @Column(nullable = false)
    private float moda1;
    @Column(nullable = false)
    private float moda2;
    @Column(nullable = false)
    private float moda3;
    @Column(nullable = false)
    private float moda4;
    @Column(nullable = false)
    private float moda5;

    private boolean active = true;

    private String chemicalName;//марка металла

    @OneToMany(cascade = CascadeType.ALL)
    private List<TestWork> testList;

}
