package com.example.examplewordpres.dto;

import com.example.examplewordpres.entity.Proba;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestProbaDTO {

    private String name;
    private Proba proba;

}
