package com.example.examplewordpres.service;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.dto.LaboratoryDTO;
import com.example.examplewordpres.dto.TestLadleDTO;
import com.example.examplewordpres.dto.TestProbaDTO;
import com.example.examplewordpres.entity.*;
import com.example.examplewordpres.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Laboratoryservice {

    private final LaboratoryRepository laboratoryRepository;
    private final TestProbaRepository testProbaRepository;
    private final TestLadleRepositroy testLadleRepositroy;
    private final ProbaRepository probaRepository;
    private final LadleRepository ladleRepository;


    public ApiResponse save(Laboratory laboratory){
        Laboratory save = laboratoryRepository.save(laboratory);
        return new ApiResponse("Save",true);
    }


    public ApiResponse update(Long id, LaboratoryDTO laboratoryDTO){

        Optional<Laboratory> byId = laboratoryRepository.findById(id);
        if (byId.isPresent()) {
            Laboratory labaratory = byId.get();
            labaratory.setTotal(laboratoryDTO.getTotal());
            labaratory.setSlag(laboratoryDTO.getSlag());
            labaratory.setByskachShlag(laboratoryDTO.getByskachShlag());
            labaratory.setAdditivesFeMn(laboratoryDTO.getAdditivesFeMn());
            labaratory.setMassaFeMn(laboratoryDTO.getMassaFeMn());
            labaratory.setAdditivesFeSi(laboratoryDTO.getAdditivesFeSi());
            labaratory.setMassaFeSi(laboratoryDTO.getMassaFeSi());
            labaratory.setFev(laboratoryDTO.getFev());
            labaratory.setAl(laboratoryDTO.getAl());
            labaratory.setFeP(laboratoryDTO.getFeP());
            labaratory.setSiCa(laboratoryDTO.getSiCa());
            labaratory.setTempBegin(laboratoryDTO.getTempBegin());
            labaratory.setTempEnd(laboratoryDTO.getTempEnd());
            labaratory.setTimeBegin(laboratoryDTO.getTimeBegin());
            labaratory.setTimeEnd(laboratoryDTO.getTimeEnd());
            labaratory.setRemarks(laboratoryDTO.getRemarks());

            List<TestLadleDTO> ladles = laboratoryDTO.getLadles();
            List<TestProbaDTO> probas = laboratoryDTO.getProbas();

            List<TestLadle> ladles1 = labaratory.getLadles();
            List<TestProba> probas1 = labaratory.getProbas();

            for (int i = 0; i < laboratoryDTO.getProbas().size(); i++) {

                TestLadleDTO testLadleDTO = ladles.get(i);
                Ladle ladle1 = testLadleDTO.getLadle();
                TestProbaDTO testProbaDTO = probas.get(i);
                Proba proba1 = testProbaDTO.getProba();

                TestLadle testLadle = ladles1.get(i);
                Ladle ladle = testLadle.getLadle();

                TestProba testProba = probas1.get(i);
                Proba proba = testProba.getProba();

                testLadle.setName(testLadleDTO.getName());
                testLadleRepositroy.save(testLadle);
                testProba.setName(testProbaDTO.getName());
                testProbaRepository.save(testProba);

                ladle.setModa1(ladle1.getModa1());
                ladle.setModa1(ladle1.getModa2());
                ladle.setModa1(ladle1.getModa3());
                ladle.setModa1(ladle1.getModa4());
                ladle.setModa1(ladle1.getModa5());
                ladle.setModa1(ladle1.getModa6());
                ladle.setLocalTime(ladle1.getLocalTime());
                ladleRepository.save(ladle);

                proba.setModa1(proba1.getModa1());
                proba.setModa1(proba1.getModa2());
                proba.setModa1(proba1.getModa3());
                proba.setModa1(proba1.getModa4());
                proba.setModa1(proba1.getModa5());
                proba.setModa1(proba1.getModa6());
                proba.setLocalTime(proba1.getLocalTime());
                probaRepository.save(proba);
            }
            laboratoryRepository.save(labaratory);

        }


        return new ApiResponse("update",true);
    }
}
