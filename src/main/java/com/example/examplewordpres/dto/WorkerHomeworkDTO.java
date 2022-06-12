package com.example.examplewordpres.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerHomeworkDTO {

    private Integer bake;
    private Long fuse;
    private LocalDateTime localDateTime;
    private String smelter;
    private float moda1;
    private float moda2;
    private float moda3;
    private float moda4;
    private float moda5;
    private String chemicalName;
    private List<TestWorkDTO> testList;

}
