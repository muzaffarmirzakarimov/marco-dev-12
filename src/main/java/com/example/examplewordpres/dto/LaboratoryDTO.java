package com.example.examplewordpres.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LaboratoryDTO {

    private Integer total;
    private Integer slag;
    private Integer byskachShlag;
    private Float additivesFeMn;
    private Integer massaFeMn;
    private Float additivesFeSi;
    private Integer massaFeSi;
    private Integer fev;
    private Integer al;
    private Integer feP;
    private Integer siCa;

    private Integer tempBegin;

    private Integer tempEnd;

    private LocalTime timeBegin;

    private LocalTime timeEnd;

    private String remarks;

    private List<TestProbaDTO> probas;

    private List<TestLadleDTO> ladles;
}
