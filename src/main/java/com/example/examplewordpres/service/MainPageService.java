package com.example.examplewordpres.service;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.dto.MainPageDTO;
import com.example.examplewordpres.entity.MainPage;
import com.example.examplewordpres.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainPageService {


    private final DetailDescriptionRepository detailDescriptionRepository;
    private final LaboratoryRepository laboratoryRepository;
    private final ChemicalRepository chemicalRepository;
    private final WorkerHomeworkRepository workerHomeworkRepository;
    private final MainPageRepository mainPageRepository;

    public ApiResponse save(MainPageDTO mainPageDTO){
        MainPage mainPage1=new MainPage();

        mainPage1.setSmelter(mainPageDTO.getSmelter());

        mainPage1.setSmeltingMaster(mainPageDTO.getSmeltingMaster());

        mainPage1.setControllerOTK(mainPageDTO.getControllerOTK());


        mainPage1.setSectionManager(mainPageDTO.getSectionManager());


        mainPage1.setWorkerHomework(workerHomeworkRepository.findById(mainPageDTO.getWorkerHomeworkId()).get());

        mainPage1.setLaboratory(laboratoryRepository.findById(mainPageDTO.getLaboratoryId()).get());

        mainPage1.setDetailDescription(detailDescriptionRepository.findById(mainPageDTO.getDetailDescriptionId()).get());
        mainPageRepository.save(mainPage1);

        return new ApiResponse("save",true);
    }

}
