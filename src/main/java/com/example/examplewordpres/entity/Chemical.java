package com.example.examplewordpres.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Chemical {

    @Id
    private String name;//marka metall
    @Column(nullable = false)
    private String moda1;//C
    @Column(nullable = false)
    private String moda2;//Mn
    @Column(nullable = false)
    private String moda3;//Si
    @Column(nullable = false)
    private String moda4;//P
    @Column(nullable = false)
    private String moda5;//HB
}
