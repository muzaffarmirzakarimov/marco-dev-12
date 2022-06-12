package com.example.examplewordpres.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MainPageDTO {

    private String smelter;
    private String smeltingMaster;
    private String controllerOTK;
    private String sectionManager;

    private Long workerHomeworkId;
    private Long laboratoryId;
    private Long detailDescriptionId;

}
