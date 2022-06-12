package com.example.examplewordpres.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DetailDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caster1; // ism familya 1
    private String caster2; // ism familya 2
    private boolean active=true;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pourer> list;

}
