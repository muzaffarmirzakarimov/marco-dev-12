package com.example.examplewordpres.dto;

import com.example.examplewordpres.entity.Pourer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDescriptionDTO {

    private String caster1;
    private String caster2;
    private List<Pourer> list;
}
