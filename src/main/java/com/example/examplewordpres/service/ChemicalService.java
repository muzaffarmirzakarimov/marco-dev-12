package com.example.examplewordpres.service;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.entity.Chemical;
import com.example.examplewordpres.repository.ChemicalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChemicalService {

    private final ChemicalRepository chemicalRepository;

    public ApiResponse save(Chemical chemical){
        chemicalRepository.save(chemical);
        return new ApiResponse("saved",true);
    }
    public ApiResponse updete(String name, Chemical chemical){
        Optional<Chemical> byId = chemicalRepository.findByName(name);
        if (byId.isPresent()) {
            Chemical updete = byId.get();
            updete.setName(chemical.getName());
            updete.setModa1(chemical.getModa1());
            updete.setModa2(chemical.getModa2());
            updete.setModa3(chemical.getModa3());
            updete.setModa4(chemical.getModa4());
            updete.setModa5(chemical.getModa5());
            chemicalRepository.save(updete);
            return new ApiResponse("updete",true);
        }else {
            return new ApiResponse("Not found",false);
        }

    }
}
